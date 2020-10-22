import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class Oblig2 {

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        Scanner in = new Scanner(new File(filename));

        int n = in.nextInt();
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(i + 1);
        }

        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            Task task = tasks[id - 1];
            task.name = in.next();
            task.time = in.nextInt();
            task.staff = in.nextInt();

            while (true) {
                int dep = in.nextInt();
                if (dep == 0) {
                    break;
                }
                tasks[dep - 1].addEdge(task);
                tasks[id - 1].cntPredecessors++;
		tasks[id - 1].addPred(tasks[dep - 1]);
            }
        }

	TaskManager taskManager = new TaskManager(tasks);
	TaskManager orderedTasks = new TaskManager(taskManager.manageTasks());
	System.out.println(orderedTasks);

	if (orderedTasks.n == tasks.length)
	    System.out.println(orderedTasks.displayWorkProcess());
    }
}
