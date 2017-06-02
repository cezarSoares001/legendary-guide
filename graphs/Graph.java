package br.pucrs.ap3.graphs;

public class Graph extends AbstractGraph {

	public Graph(int size) {
		super(size);
	}

	public void addEdge(int i, int j, int value) {
		checkNode(i);
		checkNode(j);
		m[i][j] = value;
		m[j][i] = value;
	}

}
