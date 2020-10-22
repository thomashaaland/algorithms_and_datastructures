class TestGraph {

    public static void main(String[] args) {
	Graph<String> g = new Graph();
	for (int i = 0; i < 7; i++) {
	    g.addNode(i, "A");
	}
	g.add2WEdge(0, 1);
	g.add2WEdge(0, 2);
	g.add2WEdge(0, 3);
	g.add2WEdge(1, 2);
	g.add2WEdge(2, 3);
	g.add2WEdge(2, 5);
	g.add2WEdge(3, 4);
	g.add2WEdge(4, 5);
	g.add2WEdge(5, 6);

	System.out.println(g);

	System.out.println(g.depthSearch());
	System.out.println(g.breadthSearch());

	Graph<String> g2 = new Graph();
	for (int i = 1; i <= 8; i++) {
	    g2.addNode(i, "B");
	}
	g2.addEdge(1, 3);
	g2.addEdge(2, 3);
	g2.addEdge(2, 4);
	g2.addEdge(3, 5);
	g2.addEdge(3, 6);
	g2.addEdge(4, 6);
	g2.addEdge(5, 7);
	g2.addEdge(6, 7);
	g2.addEdge(6, 8);

	

	System.out.println(g2);
    	System.out.println(g2.topologicalSort());

	System.out.println(g2.getData(2));

	System.out.println("Hamiltonian cycle");
	Graph<String> g3 = new Graph();
	for (int i = 0; i < 5; i++) {
	    g3.addNode(i, "B");
	}
	System.out.println("Does not have a hamiltonian cycle");
	g3.addEdge(0,1);
	g3.addEdge(1,2);
	g3.addEdge(2,3);
	g3.addEdge(3,4);
	System.out.println(g3);
	System.out.println("Has HamiltonianCrircuit " + g3.hasHamiltonianCircuit());
	System.out.println("Has EulerCircuit: " + g3.hasEulerCircuit());

	Graph<String> g4 = new Graph();
	for (int i = 0; i < 5; i++) {
	    g4.addNode(i, "B");
	}
	System.out.println("Does have a hamiltonian cycle");
	g4.addEdge(0,1);
	g4.addEdge(1,2);
	g4.addEdge(2,3);
	g4.addEdge(3,4);
	g4.addEdge(4,0);
	System.out.println(g4);
	System.out.println("Has HamiltonianCrircuit " + g4.hasHamiltonianCircuit());
	System.out.println("Has EulerCircuit: " + g4.hasEulerCircuit());

	//System.out.println(g4.prim());
	
    }
		
}
