package fr.inria.diverse.ad.algebra.operation;

import java.util.List;

import activitydiagram.Token;

public interface ActivityEdgeOperation {

	List<Token> takeOfferedTokens();

	boolean hasOffer();

	void sendOffer(List<Token> tokens);

}
