package com.basic;
import java.util.*;

public class Graph
{
    private int vertices = 0;
    private int edges = 0;
    private Vertice[] map;

    public Graph(int size)
    {
        vertices = size;
        map = new Vertice[size];

        for(int i = 0; i < vertices; i++)
        {
            map[i] = new Vertice(i);
        }
    }

    public int vertices() {return vertices;}
    public int edges() {return edges;}

    public void addEdge(int vertice1, int vertice2)
    {
        if(vertice1 < 0 | vertice1 >= vertices ) return;
        if(vertice2 < 0 | vertice2 >= vertices ) return;

        if(!map[vertice1].list.contains(vertice2))
        {
            map[vertice1].list.add(vertice2);
            edges++;
        }
        if(!map[vertice2].list.contains(vertice1))
        {
            map[vertice2].list.add(vertice1);
            edges++;
        }

    }
    public Integer[] edgesOfVertice(int vertice)
    {
        if(vertice >= vertices | vertice < 0) return null;

        return map[vertice].list.toArray(new Integer[0]);
    }

    public void display()
    {
        for(int i = 0; i < vertices; i++)
        {
            System.out.println("Vertice " + i + " has edges: " + Arrays.toString(edgesOfVertice(i)));
        }
    }

}
