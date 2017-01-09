package fr.inria.diverse.ad.algebra.benchmark;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.modelexecution.operationalsemantics.ActivityDiagramInputStandaloneSetup;
import org.modelexecution.operationalsemantics.ActivityDiagramStandaloneSetup;

import com.google.common.io.Files;

import activitydiagram.Activity;
import activitydiagram.ActivityEdge;
import activitydiagram.ActivityNode;
import activitydiagram.ActivitydiagramPackage;
import activitydiagram.Expression;
import activitydiagram.Input;
import activitydiagram.InputValue;
import activitydiagram.Offer;
import activitydiagram.Token;
import activitydiagram.Trace;
import activitydiagram.Value;
import activitydiagram.Variable;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityEdgeOperation;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;
import fr.inria.diverse.ad.algebra.operation.ActivityOperation;
import fr.inria.diverse.ad.algebra.operation.ExpressionOperation;
import fr.inria.diverse.ad.algebra.operation.TokenOperation;
import fr.inria.diverse.ad.algebra.operation.OfferOperation;

public class Benchmark {

	public static void main(String[] args) throws IOException {
		new Benchmark().bench();
	}
	
	

	
	protected XtextResourceSet resourceSet;
	public Benchmark() {

	}

	private void bbb(String string, String string2, int limit, Map<Integer, Long> map) throws IOException {
		long res = executeActivity("model/" + string + ".xmi", string2 == null ? null : "model/" + string2 + ".xmi", limit, map);
//		Files.write(file.toPath(), ("Bench " + string + ".xmi = " + res + "\n").getBytes());
		System.out.println("Bench " + string + ".xmi = " + res);
//		append(, file, Charset.defaultCharset());
	}

	public void bench() throws IOException {
		File file = new File("results.csv");
		if (file.exists()) {
			file.delete();
		}
		int limit = 100;
		
		// first key = exp, second key = iteration, value = time;
		final Map<Integer, Map<Integer, Long>> times = new HashMap<>();
		times.put(1, new HashMap<>());
		times.put(2, new HashMap<>());
		times.put(3, new HashMap<>());
		times.put(4, new HashMap<>());
		bbb("testperformance_variant1", null, limit, times.get(1));
		bbb("testperformance_variant2", null, limit, times.get(2));
		bbb("testperformance_variant3_1", null, limit, times.get(3));
		bbb("testperformance_variant3_2", "testperformance_variant3_2_input", limit, times.get(4));
		
		for(int i=0; i<limit; i++) {
			Long val1 = times.get(1).get(i);
			Long val2 = times.get(2).get(i);
			Long val3 = times.get(3).get(i);
			Long val4 = times.get(4).get(i);
			
			Files.append("me;"+i+";"+val1+";"+val2+";"+val3+";"+val4+"\n", file, Charset.defaultCharset());
		}

		
		// model/testperformance_variant2
		// model/testperformance_variant3_1
		// model/testperformance_variant3_2
	}

	

	final protected File createFile(final String path) {
		return new File(path);
	}

	final private URI createFileURI(final String path) {
		return URI.createFileURI(createFile(path).getAbsolutePath());
	}

	private long execOnce(String modelPath, String inputPath) {
		init();
		final Activity activity = getActivity(modelPath);
		final List<InputValue> inputValues = getInputValues(inputPath);

		final ExecutableADAlgebra executableADAlgebra = new ExecutableADAlgebra() {

			private final Map<ActivityNode, ActivityNodeOperation> activityNodeMemo = new IdentityHashMap<>();
			private Map<ActivityEdge, ActivityEdgeOperation> activityEdgeMemo = new IdentityHashMap<>();

			@Override
			public Map<ActivityNode, ActivityNodeOperation> getActivityNodeMemo() {
				return this.activityNodeMemo;
			}

			@Override
			public Map<ActivityEdge, ActivityEdgeOperation> getActivityEdgeMemo() {
				return this.activityEdgeMemo;
			}
		};

		final long start = System.currentTimeMillis();
		executableADAlgebra.$(activity).main(inputValues);
		final long stop = System.currentTimeMillis();

		return stop - start;
	}
//
//	private long executeActivity(String modelPath, int limit, Map<Integer, Integer> map) {
//		return executeActivity(modelPath, null, limit, map);
//
//	}

	private long executeActivity(String modelPath, String inputPath, int limit, Map<Integer, Long> map) {
		long ttl = 0;
		for (int i = 0; i < limit; i++) {
			map.put(i, execOnce(modelPath, inputPath));
		}

		return ttl / limit;

	}

	protected Activity getActivity(final String modelPath) {
		final Resource resource = resourceSet.getResource(createFileURI(modelPath), true);
		final EObject eObject = resource.getContents().get(0);
		if (eObject instanceof Activity) {
			final Activity activity = (Activity) eObject;
			return activity;
		}
		return null;
	}

	protected Input getInput(final String inputPath) {
		Input input = null;
		if (inputPath != null) {
			final Resource resource = resourceSet.getResource(createFileURI(inputPath), true);
			final EObject eObject = resource.getContents().get(0);
			if (eObject instanceof Input) {
				input = (Input) eObject;
			}
		}
		return input;
	}

	final private List<InputValue> getInputValues(final String inputPath) {
		final List<InputValue> inputValues = new ArrayList<InputValue>();
		final Input input = getInput(inputPath);
		if (input != null) {
			inputValues.addAll(input.getInputValues());
		}
		return inputValues;
	}

	private void init() {
		resourceSet = new XtextResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		ActivitydiagramPackage adPack = ActivitydiagramPackage.eINSTANCE;

		ActivityDiagramStandaloneSetup.doSetup();
		ActivityDiagramInputStandaloneSetup.doSetup();
	}
}
