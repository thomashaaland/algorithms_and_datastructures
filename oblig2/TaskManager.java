import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

class TaskManager {
    Task[] tasks;
    int n;
    
    public TaskManager(Task[] tasks) {
	this.tasks = tasks;
	n = tasks.length;
    }

    // This method is based on topological sort.
    // However, there is some differences, it returns a
    // list of lists where Tasks are grouped according
    // to their topological order. If there exists one or
    // more cycles an empty ArrayList will be returned.
    public ArrayList< Stack<Task> > topologicalSort() {
	// Idea: collect all nodes without dependencies into a stack and append
	// this stack to the output

	// Create an empty stack
	Stack<Task> S = new Stack<>();
	Stack<Task> sCopy = new Stack<>();
	
	// Create the outputlist
	ArrayList< Stack<Task> > output = new ArrayList<>();

	// Check to see which tasks doesn't have dependencies
	for (Task task : tasks) {
	    if (task.cntPredecessors == 0) {
		S.push(task);
	    }
	}

	int i = 1;
	while (S.size() > 0) {
	    sCopy = S;
	    output.add(S);
	    i += S.size();
	    S = new Stack<>();
	    for (Task task : sCopy) {
		for (Task outEdge : task.outEdges) {
		    outEdge.cntPredecessors--;
		    if (outEdge.cntPredecessors == 0) S.push(outEdge);
		}
	    }
	}
	if (i > n) return output;
	
	output = new ArrayList<>();
	return output;
    }

    // Method for finding a cycle. This method initates on all tasks and
    // then finds the shortest path among those found.
    private Stack<Task> findCircuit() {
	Stack< Stack<Task> > paths = new Stack<>();
	Stack<Task> aPath;
	for (Task task : tasks) {
	    circuit(task, task, paths, new Stack<>());
	}
	aPath = paths.pop();
	for (Stack<Task> path : paths) {
	    if (path.size() < aPath.size()) {
		aPath = path;
	    }
	}
	return aPath;
    }

    // Recursive method for finding a cycle. Initiated by findCircuit
    // This method recollects the start task, holds a copy of path and adds this path
    // to paths. It is based on finding a Hamiltonian circuit
    private void circuit(Task start, Task current, Stack< Stack<Task> > paths, Stack<Task> path) {
	if (current.containedIn(path) && current.id == start.id) {
	    paths.push(path);
	}
	else if (path.size() < n) {
	    path.push(current);
	    
	    for (Task edge : current.outEdges) {
		Stack<Task> pathCopy = new Stack<>();
		for (Task task : path) pathCopy.push(task);
		circuit(start, edge, paths, pathCopy);
	    }
	}
    }
    
    public Task[] manageTasks() {
	ArrayList< Stack <Task> > orderedTasks = new ArrayList<>();
	orderedTasks = topologicalSort();
	// Check if there has been found a cycle
	//****************************************
	if (orderedTasks.size() == 0) {
	    Stack<Task> circuit = findCircuit();
	    Task[] output = new Task[circuit.size()];
	    int i = 0;
	    for (Task task : circuit) {
		output[i++] = task;
	    }
	    System.out.println("**********************************************");
	    System.out.println("DETECTED A CIRCUIT: Project is not realizable!");
	    System.out.println("         Printing the circuit                 ");
	    System.out.println("**********************************************");
	    return output;
	}
	// Assign starttimes to each task
	for (Stack<Task> tasks : orderedTasks) {
	    for (Task task : tasks) {
		task.assignTaskTimes();
	    }
	}

	// Find the slack
	for (Stack<Task> tasks : orderedTasks) {
	    for (Task task : tasks) {
		task.findSlack();
	    }
	}
	Task[] output = new Task[n];
	int i = 0;
	for (Stack<Task> tasks : orderedTasks) {
	    for (Task task : tasks) {
		output[i++] = task;
	    }
	}
    	return output;
    }

    public String displayWorkProcess() {
	String outputString = "";
	String temp = "";
	int pStart = tasks[0].start;
	int pFinish = tasks[n-1].finish;
	int crew = 0;
	for (int i = pStart; i <= pFinish; i++) {
	    temp = "";
	    for (Task task : tasks) {
		if (task.start == i) {
		    temp += "\tStarting: " + task.id + "\n";
		    crew += task.staff;
		}
		else if (task.finish == i) {
		    temp += "\tFinished: " + task.id + "\n";
		    crew -= task.staff;
		}
		else {
		    continue;
		}
	    }
	    if (temp.length() > 0)
		outputString += "Time:\n" + i + "\n" + temp + "\tCurrent Staff: " + crew + '\n';
	}
	outputString += "\n*** Shortest possible project execution is " + pFinish + " ***";
	    
	return outputString;
    }

    @Override
    public String toString() {
	String out = String.format("%6s %35s %12s %12s %12s %12s %12s %30s %30s\n",
				   "ID", "Taskname", "Task time", "Start time", 
				   "End time", "Staff", "Slack", "OutEdges", "InEdges");
	for (int i = 0; i < n; i++) {
	    out += tasks[i].toString() + '\n';
	}
	return out;
    }
}
