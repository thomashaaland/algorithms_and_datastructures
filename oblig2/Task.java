import java.util.List;
import java.util.ArrayList;

class Task {
    int id, time, staff;
    String name;
    int start, finish;
    List<Task> outEdges;
    List<Task> inEdges;
    int cntPredecessors;
    int slack;

    public Task(int id) {
	this.id = id;
	outEdges = new ArrayList<>();
	inEdges = new ArrayList<>();
	int slack = 0;
    }

    public void addEdge(Task task) {
	outEdges.add(task);
    }

    public void addPred(Task task) {
	inEdges.add(task);
    }

    // A method for finding if this task is in a list
    public boolean containedIn(List<Task> list) {
	for (Task t : list) {
	    if (id == t.id) return true;
	}
	return false;
    }

    private String edgesToString(List<Task> edges) {
	String edgeString = "[";
	if (edges.size() > 0) edgeString += edges.get(0).id;
	for (int i = 1; i < edges.size(); i++) {
	    edgeString += ", " + edges.get(i).id;
	}
	edgeString += "]";
	return edgeString;
    }


    // Method for assigning task times
    public void assignTaskTimes() {
	start = 0;
	for (Task inTask : inEdges) {
	    if (inTask.finish > start) {
		start = inTask.finish;
	    }
	}
	finish = start + time;
    }

    // Method for finding the Slack
    public void findSlack() {
	int maxTime = 0;
	for (Task inTask : inEdges) {
	    if (maxTime < inTask.finish) {
		maxTime = inTask.finish;
	    }
	}
	for (Task inTask : inEdges) {
	    if (!inTask.hasChildrenAsParentsOf(this)) {
		inTask.slack = maxTime - inTask.finish;
	    }
	}
    }

    public boolean hasChildrenAsParentsOf(Task task) {
	for (Task child : outEdges) {
	    if (child.containedIn(task.inEdges)) return true;
	}
	return false;
    }
    
    @Override
    public String toString() {
	String outEdgeString = edgesToString(outEdges); 
	String inEdgeString = edgesToString(inEdges);
	
	return String.format("%6s %35s %12s %12s %12s %12s %12s %30s %30s",
			     id, name, time, start, finish,
			     staff, slack, outEdgeString, inEdgeString);
    }
    
}
