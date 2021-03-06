package br.pucrs.ap3.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Grafo n�o-dirigido (Directed graph - Digrafo).
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public abstract class AbstractGraph {

	protected int[][] m;

	public AbstractGraph(int size) {
		if (size <= 0)
			throw new IllegalArgumentException("Size must be 1 or more.");
		m = new int[size + 1][size + 1];
	}

	@Override
	public String toString() {
		String r = "    ";
		for (int j = 1; j < m.length; j++) {
			r += j + " ";
		}
		r += "\n";
		r += "  +";
		for (int j = 1; j < m.length; j++) {
			r += "--";
		}
		r += "\n";
		for (int i = 1; i < m.length; i++) {
			r += i + " | ";
			for (int j = 1; j < m.length; j++) {
				r += m[i][j] + " ";
			}
			r += "\n";
		}
		return r;
	}

	public void addEdge(int i, int j) {
		addEdge(i, j, 1);
	}

	public abstract void addEdge(int i, int j, int value);

	protected void checkNode(int i) {
		if (i <= 0 || i >= m.length)
			throw new IllegalArgumentException("Invalid node:" + i);
	}

	public List<Integer> getNext(int i) {
		checkNode(i);
		List<Integer> r = new ArrayList<Integer>();
		for (int j = 1; j < m.length; j++) {
			if (m[i][j] != 0)
				r.add(j);
		}
		return r;
	}
	
	//enum {
	//	
	//}
	private static final int WHITE = 10;
	private static final int GRAY = 20;
	private static final int BLACK = 30;
	
	// TODO marcar se foi visitado, para evitar ciclos
	public List<Integer> breadth(int s) {
		checkNode(s);
		// 1 - 7
		// TODO trocar para enum!
		int color[] = new int[m.length];
		int d[] = new int[m.length];
		int p[] = new int[m.length];
		for (int u = 1; u < color.length; u++) {
			color[u] = WHITE;
			d[u] = 1000;
			p[u] = -1;
		}
		color[s] = GRAY;
		d[s] = 0;
		p[s] = -1;
		// 8, 9
		List<Integer> Q = new LinkedList<Integer>();
		Q.add(s);
		//10
		while (  ! Q.isEmpty() ) {
			// TODO: confirmar se eh uma fila!
			int u = Q.remove(0);
			for (Integer v : getNext(u)) {
				if (color[v] == WHITE) {
					color[v] = GRAY;
					d[v] = d[u] + 1;
					p[v] = u;
					Q.add(v);
				}
			}
			color[u] = BLACK;
		}
		
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(p));
		
		return null;
	}

	public List<Integer> depth(int i) {
		checkNode(i);
		// TODO
		return null;
	}
}
