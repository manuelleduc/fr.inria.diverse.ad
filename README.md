# Activity Diagrams

## Introduction

This projet gather a lot of different implementation of the implementation of the activity diagram usecase described [here](https://github.com/moliz/moliz.ttc2015).

## Object algebra

### Description

The object algebra approach is based on the generation of an interface from the business model. This interface is then used by the semantic developer.

### Artifacts
  - [fr.inria.diverse.ad.algebra](./fr.inria.diverse.ad.algebra): The object algebra semantic implementation
  - [fr.inria.diverse.ad.algebra.benchmark](./fr.inria.diverse.ad.algebra.benchmark): The benchmarking code (simply run the semantic many time on the 4 performance tests described in the transformation contest).
  - [fr.inria.diverse.ad.algebra.test](./fr.inria.diverse.ad.algebra.test): The transformation contest test suite adapted to the object algebra case.


## Visitor \#1

### Description

This first implementation of the visitor is based on the Switch pattern generated by EMF.

### Artifacts

  - [fr.inria.diverse.ad.visitor](fr.inria.diverse.ad.visitor): The visitor semantic implementation
  - [fr.inria.diverse.ad.visitor.benchmark](fr.inria.diverse.ad.visitor.benchmark): The benchmarking code
  - [fr.inria.diverse.ad.visitor.test](fr.inria.diverse.ad.visitor.test): The default test suite.


## Visitor \#2

### Description

This second implementation of the visitor is based on the "classical" GoF pattern. In this case the generated EMF java code is updated with an `accept(Visitor<X> method)` witch then calls the relavance method in the interface using polymorphism.

### Artifacts

  - [fr.inria.diverse.ad.visitor2.model](fr.inria.diverse.ad.visitor2.model): The same model as usual but updated with the `accept` methods.


## org.modelexecution.*

All those artifacts are copied from the standard transformation contest implementation and are used for parsing and editing activity diagram models.
