package com.example.quiz_app
data class NodeData(val id: String, val label: String)
data class EdgeData(val from: String, val to: String)
data class Roadmap(val nodes: List<NodeData>, val edges: List<EdgeData>)
