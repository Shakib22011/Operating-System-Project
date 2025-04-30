package os;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class project extends JFrame{
    ImageIcon icon;
    Container c;
    JLabel title,input,output,category,selection,arrivalLabel,bustLabel,quantumLabel,priorityLabel,queueLabel,headLabel,frameLabel,memoryLabel,processLabel,rangeLabel;
    Font titlefont,inlabelfont1,inlabelfont2,solvefont;
    JComboBox ComseletCat,ComseletAlgo;
    JTextField arrivalText,bustText,quantumText,priorityText,queueText,headText,frameText,memoryText,processText,rangeText;
    String[] str1={"Select a Category First","Process Scheduling","Disk Scheduling","Page Replacement","Memory Allocation"};
    String[] str2={"Select an Algorithm"};
    String[] Process={"FCFS","Priority Scheduling non-prem","Priority Scheduling prem","Shortest Job First non-prem","Shortest Job First prem","Round-Robin"};
    String[] Disk={"First Come First Serve","SSTF","SCAN","C-SCAN","LOOK","C-LOOK"};
    String[] Paging={"FIFO","Last Recently Used","Optimal"};
    String[] Memory={"First Fit","Best Fit","Worst Fit"};
    JButton btn;
    JTable table;
    JScrollPane scroll;
    DefaultTableModel model;
    Cursor cursor;

    public static void main(String[] args) {
        project frame=new project();
    }

    //Constructor of Project class
    project(){
        initcomponents();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Operating System");
        setResizable(false);
        setBounds(300,100,1100,650);
    }

    //initcomponents method starts here
    void initcomponents(){
        icon = new ImageIcon(getClass().getResource("os1.png"));
        this.setIconImage(icon.getImage());
        c=this.getContentPane();   //adding container
        c.setLayout(null);
        c.setBackground(new Color(255,253,208));

        titlefont=new Font("Arrial",Font.BOLD,25);

        title=new JLabel("Operating System Algorithms Solver");
        title.setBounds(300,5,450,30);
        title.setFont(titlefont);
        c.add(title);

        //input label and comboboxes
        input=new JLabel("Input  Lbael");
        inlabelfont1=new Font("Arrial",Font.BOLD,18);
        input.setBounds(10,80,120,24);
        input.setFont(inlabelfont1);
        c.add(input);

        category=new JLabel("Select Category");
        category.setBounds(10,130,120,24);
        inlabelfont2=new Font("Arrial",Font.CENTER_BASELINE,14);
        category.setFont(inlabelfont2);
        c.add(category);

        //combobox for category selection
        ComseletCat=new JComboBox(str1);
        ComseletCat.setBounds(10,160,170,28);
        c.add(ComseletCat);

        selection= new JLabel("Select Algorithm");
        selection.setBounds(10,220,120,24);
        selection.setFont(inlabelfont2);
        c.add(selection);

        //combobox for algo selection
        ComseletAlgo=new JComboBox(str2);
        ComseletAlgo.setBounds(10,250,170,28);
        c.add(ComseletAlgo);

        //arrival label and textfield
        arrivalLabel=new JLabel("Arrival Time");
        arrivalLabel.setBounds(10,310,160,24);
        arrivalLabel.setFont(inlabelfont2);
        c.add(arrivalLabel);

        arrivalText=new JTextField();
        arrivalText.setBounds(10,340,170,28);
        arrivalText.setToolTipText("Arrival times must be separated by Commas.");
        c.add(arrivalText);

        //bust time label and textfield
        bustLabel=new JLabel("Bust Time");
        bustLabel.setBounds(10,370,160,24);
        bustLabel.setFont(inlabelfont2);
        c.add(bustLabel);

        bustText=new JTextField();
        bustText.setBounds(10,400,170,28);
        bustText.setToolTipText("Bust times must be separated by Commas.");
        c.add(bustText);

        //quantum label and textfield
        quantumLabel=new JLabel("Quantum Time");
        quantumLabel.setBounds(10,430,160,24);
        quantumLabel.setFont(inlabelfont2);
        c.add(quantumLabel);

        quantumText=new JTextField();
        quantumText.setBounds(10,460,170,28);
        quantumText.setToolTipText("Quantum time must be a single number (Smaller expected).");
        c.add(quantumText);

        //Priority lable and textfield
        priorityLabel=new JLabel("Priority Queue");
        priorityLabel.setBounds(10,430,160,24);
        priorityLabel.setFont(inlabelfont2);
        c.add(priorityLabel);

        priorityText=new JTextField();
        priorityText.setBounds(10,460,170,28);
        priorityText.setToolTipText("Priority serial numbers must be separated by Commas.");
        c.add(priorityText);

        //Queue lable and textfield
        queueLabel=new JLabel("Referance String");
        queueLabel.setBounds(10,310,160,24);
        queueLabel.setFont(inlabelfont2);
        c.add(queueLabel);

        queueText=new JTextField();
        queueText.setBounds(10,340,170,28);
        queueText.setToolTipText("Queue pointers must be separated by Commas.");
        c.add(queueText);

        //headpointer label and textfield
        headLabel=new JLabel("Headpointer");
        headLabel.setBounds(10,370,160,24);
        headLabel.setFont(inlabelfont2);
        c.add(headLabel);

        headText=new JTextField();
        headText.setBounds(10,400,170,28);
        headText.setToolTipText("Headpointer must be a single number in the range.");
        c.add(headText);

        //frame label and textfield for paging algorithm
        frameLabel=new JLabel("Frame Number");
        frameLabel.setBounds(10,370,160,24);
        frameLabel.setFont(inlabelfont2);
        c.add(frameLabel);

        frameText=new JTextField();
        frameText.setBounds(10,400,170,28);
        frameText.setToolTipText("Frame number must be a single number.");
        c.add(frameText);

        //momory label and textfield for momory management algo
        memoryLabel=new JLabel("Memory Partitions");
        memoryLabel.setBounds(10,310,160,24);
        memoryLabel.setFont(inlabelfont2);
        c.add(memoryLabel);

        memoryText=new JTextField();
        memoryText.setBounds(10,340,170,28);
        memoryText.setToolTipText("Memory partitions must be separated by Commas.");
        c.add(memoryText);

        //Process queue label and textfield
        processLabel=new JLabel("Process Queue");
        processLabel.setBounds(10,370,160,24);
        processLabel.setFont(inlabelfont2);
        c.add(processLabel);

        processText=new JTextField();
        processText.setBounds(10,400,170,28);
        processText.setToolTipText("Process queue numbers must be separated by commas");
        c.add(processText);

        //Range for disk scheduling algo
        rangeLabel=new JLabel("Height Range");
        rangeLabel.setBounds(10,430,160,24);
        rangeLabel.setFont(inlabelfont2);
        c.add(rangeLabel);

        rangeText=new JTextField();
        rangeText.setBounds(10,460,170,28);
        rangeText.setToolTipText("Height range must be a single number.");
        c.add(rangeText);

        //cursor for solve button
        cursor=new Cursor(Cursor.HAND_CURSOR);

        //Solve button
        btn=new JButton("Solve");
        btn.setBounds(110,520,70,30);
        btn.setCursor(cursor);
        btn.setBackground(Color.green);
        c.add(btn);

        //Output label
        output=new JLabel("Output  Lbael");
        output.setBounds(400,80,150,24);
        output.setFont(inlabelfont1);
        c.add(output);

        //Table for output
        model = new DefaultTableModel(); //init with no column
        table = new JTable(model);
        table.setRowHeight(30);
        table.setGridColor(Color.BLACK);
        table.setShowGrid(true);

        //scrollpane
        scroll=new JScrollPane(table);
        scroll.setBounds(400,130,600,350);
        c.add(scroll);

        hideTextFields();

        //Actionlistener for ComseletCat combobox
        ComseletCat.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String selectedItem = (String) ComseletCat.getSelectedItem();
                ComseletAlgo.removeAllItems();
                if("Process Scheduling".equals(selectedItem)) {
                    for(int i=0;i<Process.length;i++)
                        ComseletAlgo.addItem(Process[i]);
                }
                else if("Disk Scheduling".equals(selectedItem)) {
                    for(int i=0;i<Disk.length;i++)
                        ComseletAlgo.addItem(Disk[i]);
                }
                else if("Page Replacement".equals(selectedItem)) {
                    for(int i=0;i<Paging.length;i++)
                        ComseletAlgo.addItem(Paging[i]);
                }
                else if("Memory Allocation".equals(selectedItem)){
                    for(int i=0;i<Memory.length;i++)
                        ComseletAlgo.addItem(Memory[i]);
                }
                else {
                    ComseletAlgo.addItem("Select an Algorithm");
                }
            }
        });
        ComseletAlgo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String selectAlgorithm = (String) ComseletAlgo.getSelectedItem();

                if("FCFS".equals(selectAlgorithm) || "Shortest Job First non-prem".equals(selectAlgorithm) || "Shortest Job First prem".equals(selectAlgorithm)){
                    fcfssjf();
                }
                else if("Round-Robin".equals(selectAlgorithm)){
                    rr();
                }
                else if("Priority Scheduling non-prem".equals(selectAlgorithm) || "Priority Scheduling prem".equals(selectAlgorithm)){
                    psp();
                }//process scheduling end
                else if("First Come First Serve".equals(selectAlgorithm) || "SSTF".equals(selectAlgorithm) || "SCAN".equals(selectAlgorithm) || "C-SCAN".equals(selectAlgorithm) || "LOOK".equals(selectAlgorithm) || "C-LOOK".equals(selectAlgorithm)){
                    diskscheduling();
                }//disk scheduling ends
                else if("FIFO".equals(selectAlgorithm) || "Last Recently Used".equals(selectAlgorithm) || "Optimal".equals(selectAlgorithm)){
                    page();
                }//page ends here
                else if("First Fit".equals(selectAlgorithm) || "Best Fit".equals(selectAlgorithm) || "Worst Fit".equals(selectAlgorithm)){
                    memoryManage();
                }
                else{
                    hideTextFields();
                }
            }
        });

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String selectItems = (String) ComseletCat.getSelectedItem();
                String selectAlgorithm = (String)ComseletAlgo.getSelectedItem();
                //edited
                if ("Select a Category First".equals(selectItems) || "Select an Algorithm".equals(selectAlgorithm)) {
                    JOptionPane.showMessageDialog(null, "Please select a category and an algorithm.");
                }
                else if ("FCFS".equals(selectAlgorithm)){
                    FCFS();
                }
                else if ( "Shortest Job First non-prem".equals(selectAlgorithm)){
                    SJFnp();
                }
                else if ( "Shortest Job First prem".equals(selectAlgorithm)){
                    SJF();
                }
                else if ("Round-Robin".equals(selectAlgorithm)){
                    RR();
                }
                else if ("Priority Scheduling non-prem".equals(selectAlgorithm)){
                    Prioritynp();
                }
                else if ("Priority Scheduling prem".equals(selectAlgorithm)){
                    Priority();
                }
                else if ("First Come First Serve".equals(selectAlgorithm)){
                    fcf();
                }
                else if ("SSTF".equals(selectAlgorithm)){
                    SSTF();
                }
                else if ("SCAN".equals(selectAlgorithm)){
                    SCAN();
                }
                else if ("C-SCAN".equals(selectAlgorithm)){
                    C_SCAN();
                }
                else if ("LOOK".equals(selectAlgorithm)){
                    LOOK();
                }
                else if ("C-LOOK".equals(selectAlgorithm)){
                    C_LOOK();
                }
                else if ("FIFO".equals(selectAlgorithm)){
                    FIFO();
                }
                else if ("Last Recently Used".equals(selectAlgorithm)){
                    LRU();
                }
                else if ("Optimal".equals(selectAlgorithm)){
                    Optimal();
                }
                else if ("First Fit".equals(selectAlgorithm)){
                    First_Fit();
                }
                else if ("Best Fit".equals(selectAlgorithm)){
                    Best_Fit();
                }
                else if ("Worst Fit".equals(selectAlgorithm)){
                    Worst_Fit();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Algorithm not implemented yet!");
                }
            }
        });
    }

    void hideTextFields(){
        arrivalLabel.setVisible(false);
        arrivalText.setVisible(false);
        bustLabel.setVisible(false);
        bustText.setVisible(false);
        headLabel.setVisible(false);
        headText.setVisible(false);
        quantumLabel.setVisible(false);
        quantumText.setVisible(false);
        queueLabel.setVisible(false);
        queueText.setVisible(false);
        priorityLabel.setVisible(false);
        priorityText.setVisible(false);
        frameLabel.setVisible(false);
        frameText.setVisible(false);
        memoryLabel.setVisible(false);
        memoryText.setVisible(false);
        processLabel.setVisible(false);
        processText.setVisible(false);
        rangeLabel.setVisible(false);
        rangeText.setVisible(false);
    }

    void fcfssjf(){
        hideTextFields();
        arrivalLabel.setVisible(true);
        arrivalText.setVisible(true);
        bustLabel.setVisible(true);
        bustText.setVisible(true);
    }

    void rr(){
        hideTextFields();
        arrivalLabel.setVisible(true);
        arrivalText.setVisible(true);
        bustLabel.setVisible(true);
        bustText.setVisible(true);
        quantumLabel.setVisible(true);
        quantumText.setVisible(true);
    }

    void psp(){
        hideTextFields();
        arrivalLabel.setVisible(true);
        arrivalText.setVisible(true);
        bustLabel.setVisible(true);
        bustText.setVisible(true);
        priorityLabel.setVisible(true);
        priorityText.setVisible(true);
    }

    void  diskscheduling(){
        hideTextFields();
        queueLabel.setVisible(true);
        queueText.setVisible(true);
        headLabel.setVisible(true);
        headText.setVisible(true);
        rangeLabel.setVisible(true);
        rangeText.setVisible(true);
    }

    void page(){
        hideTextFields();
        queueLabel.setVisible(true);
        queueText.setVisible(true);
        frameLabel.setVisible(true);
        frameText.setVisible(true);
    }

    void  memoryManage(){
        hideTextFields();
        memoryLabel.setVisible(true);
        memoryText.setVisible(true);
        processLabel.setVisible(true);
        processText.setVisible(true);
    }

    Void FCFS(){
            try {
                String[] arrivalStrings = arrivalText.getText().trim().split(",");
                String[] burstStrings = bustText.getText().trim().split(",");

                if (arrivalStrings.length != burstStrings.length) {
                    JOptionPane.showMessageDialog(null, "Arrival and burst time count must match.");
                }

                int n = arrivalStrings.length;
                int[] arrivalTimes = new int[n];
                int[] burstTimes = new int[n];

                for (int i = 0; i < n; i++) {
                    arrivalTimes[i] = Integer.parseInt(arrivalStrings[i].trim());
                    burstTimes[i] = Integer.parseInt(burstStrings[i].trim());
                }

                // Pair up arrival and burst, and sort by arrival
                int[][] processes = new int[n][3]; // [][0]=arrival, [][1]=burst, [][2]=original index
                for (int i = 0; i < n; i++) {
                    processes[i][0] = arrivalTimes[i];
                    processes[i][1] = burstTimes[i];
                    processes[i][2] = i;
                }

                // Sort by arrival time
                java.util.Arrays.sort(processes, java.util.Comparator.comparingInt(a -> a[0]));

                int currentTime = 0;
                int[] completionTimes = new int[n];
                int[] turnaroundTimes = new int[n];
                int[] waitingTimes = new int[n];

                for (int i = 0; i < n; i++) {
                    int arrivalTime = processes[i][0];
                    int burstTime = processes[i][1];

                    if (currentTime < arrivalTime) {
                        currentTime = arrivalTime;
                    }

                    currentTime += burstTime;
                    completionTimes[i] = currentTime;
                    turnaroundTimes[i] = currentTime - arrivalTime;
                    waitingTimes[i] = turnaroundTimes[i] - burstTime;
                }

                int totalWT = 0, totalTAT = 0;
                for (int i = 0; i < n; i++) {
                    totalWT += waitingTimes[i];
                    totalTAT += turnaroundTimes[i];
                }

                double avgWT = (double) totalWT / n;
                double avgTAT = (double) totalTAT / n;

                model.setRowCount(0);
                model.setColumnCount(0);
                model.addColumn("Process");
                model.addColumn("Arrival Time");
                model.addColumn("Burst Time");
                model.addColumn("Completion Time");
                model.addColumn("Turnaround Time");
                model.addColumn("Waiting Time");

                for (int i = 0; i < n; i++) {
                    int arrivalTime = processes[i][0];
                    int burstTime = processes[i][1];
                    int pid = processes[i][2];
                    int tat = turnaroundTimes[i];
                    int wt = waitingTimes[i];
                    int ct = arrivalTime + tat;

                    model.addRow(new Object[]{ "P" + (pid + 1), arrivalTime, burstTime, ct, tat, wt });
                }

                model.addRow(new Object[]{"Total", "-", "-", "-", totalTAT, totalWT});
                model.addRow(new Object[]{"Average", "-", "-", "-", avgTAT, avgWT});

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
            }
            return null;
    }
    void SJFnp(){
        try {
            String[] arrivalStrings = arrivalText.getText().trim().split(",");
            String[] burstStrings = bustText.getText().trim().split(",");

            int n = arrivalStrings.length;
            int[] arrivalTimes = new int[n];
            int[] burstTimes = new int[n];
            int[] completionTimes = new int[n];
            int[] waitingTimes = new int[n];
            int[] turnaroundTimes = new int[n];
            boolean[] isCompleted = new boolean[n];

            for (int i = 0; i < n; i++) {
                arrivalTimes[i] = Integer.parseInt(arrivalStrings[i].trim());
                burstTimes[i] = Integer.parseInt(burstStrings[i].trim());
            }

            int currentTime = 0, completed = 0;
            while (completed < n) {
                int idx = -1;
                int minBurstTime = Integer.MAX_VALUE;

                for (int i = 0; i < n; i++) {
                    if (arrivalTimes[i] <= currentTime && !isCompleted[i]) {
                        if (burstTimes[i] < minBurstTime) {
                            minBurstTime = burstTimes[i];
                            idx = i;
                        }
                    }
                }

                if (idx != -1) {
                    currentTime += burstTimes[idx];
                    completionTimes[idx] = currentTime;
                    turnaroundTimes[idx] = completionTimes[idx] - arrivalTimes[idx];
                    waitingTimes[idx] = turnaroundTimes[idx] - burstTimes[idx];
                    isCompleted[idx] = true;
                    completed++;
                } else {
                    currentTime++;
                }
            }

            int TWaitingTime = 0, TTurnaroundTime = 0;
            double avgWaitingTime=0,avgTurnaroundTime=0;
            for (int i = 0; i < n; i++) {
                TWaitingTime += waitingTimes[i];
                TTurnaroundTime += turnaroundTimes[i];
            }
            avgWaitingTime= (double)TWaitingTime/ n;
            avgTurnaroundTime=(double)TTurnaroundTime / n;

            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Process");
            model.addColumn("Arrival Time");
            model.addColumn("Burst Time");
            model.addColumn("Completion Time");
            model.addColumn("Turnaround Time");
            model.addColumn("Waiting Time");

            for (int i = 0; i < n; i++) {
                model.addRow(new Object[]{i + 1, arrivalTimes[i], burstTimes[i], completionTimes[i], turnaroundTimes[i], waitingTimes[i]});
            }
            model.addRow(new Object[]{"Total", "-", "-", "-", TTurnaroundTime, TWaitingTime});
            model.addRow(new Object[]{"Average", "-", "-", "-", avgTurnaroundTime, avgWaitingTime});

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    void SJF(){
        try {
            String[] arrivalStr = arrivalText.getText().split(",");
            String[] burstStr = bustText.getText().split(",");

            int n = arrivalStr.length;
            int[] arrival = new int[n];
            int[] burst = new int[n];
            int[] remaining = new int[n];
            int[] completion = new int[n];
            int[] turnaround = new int[n];
            int[] waiting = new int[n];

            for (int i = 0; i < n; i++) {
                arrival[i] = Integer.parseInt(arrivalStr[i].trim());
                burst[i] = Integer.parseInt(burstStr[i].trim());
                remaining[i] = burst[i];
            }

            int time = 0, completed = 0;
            boolean[] isCompleted = new boolean[n];

            while (completed != n) {
                int idx = -1;
                int min = Integer.MAX_VALUE;

                for (int i = 0; i < n; i++) {
                    if (arrival[i] <= time && !isCompleted[i] && remaining[i] < min && remaining[i] > 0) {
                        min = remaining[i];
                        idx = i;
                    }
                }

                if (idx != -1) {
                    remaining[idx]--;
                    time++;

                    if (remaining[idx] == 0) {
                        completion[idx] = time;
                        isCompleted[idx] = true;
                        completed++;
                    }
                } else {
                    time++;
                }
            }

            int totalTAT = 0, totalWT = 0;

            for (int i = 0; i < n; i++) {
                turnaround[i] = completion[i] - arrival[i];
                waiting[i] = turnaround[i] - burst[i];
                totalTAT += turnaround[i];
                totalWT += waiting[i];
            }

            String[] columns = { "Process", "Arrival Time", "Burst Time", "Completion Time", "Turnaround Time", "Waiting Time" };
            model.setDataVector(new Object[0][0], columns);

            for (int i = 0; i < n; i++) {
                model.addRow(new Object[]{
                        "P" + (i + 1), arrival[i], burst[i], completion[i],
                        turnaround[i], waiting[i]
                });
            }

            model.addRow(new Object[]{
                    "Total", "", "", "", totalTAT, totalWT
            });
            model.addRow(new Object[]{
                    "Avg", "", "", "", (double) totalTAT / n, (double) totalWT / n
            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please ensure all values are correct.");
        }
    }
    void RR(){
        try {
            String[] arrivalStr = arrivalText.getText().split(",");
            String[] burstStr = bustText.getText().split(",");
            int quantum = Integer.parseInt(quantumText.getText().trim());

            int n = arrivalStr.length;
            int[] arrival = new int[n];
            int[] burst = new int[n];
            int[] remaining = new int[n];
            int[] completion = new int[n];
            int[] waiting = new int[n];
            int[] turnaround = new int[n];
            boolean[] isCompleted = new boolean[n];
            boolean[] inQueue = new boolean[n];

            for (int i = 0; i < n; i++) {
                arrival[i] = Integer.parseInt(arrivalStr[i].trim());
                burst[i] = Integer.parseInt(burstStr[i].trim());
                remaining[i] = burst[i];
            }

            int time = 0;
            int completed = 0;
            Queue<Integer> queue = new LinkedList<>();

            // Add all processes that arrive at time 0 or earliest arrival
            int earliest = Arrays.stream(arrival).min().orElse(0);
            for (int i = 0; i < n; i++) {
                if (arrival[i] == earliest) {
                    queue.add(i);
                    inQueue[i] = true;
                }
            }
            time = earliest;

            while (completed < n) {
                if (queue.isEmpty()) {
                    // Find next arrival
                    int nextArrival = Integer.MAX_VALUE;
                    int nextIndex = -1;
                    for (int i = 0; i < n; i++) {
                        if (!isCompleted[i] && arrival[i] < nextArrival) {
                            nextArrival = arrival[i];
                            nextIndex = i;
                        }
                    }

                    time = nextArrival;
                    queue.add(nextIndex);
                    inQueue[nextIndex] = true;
                }

                int idx = queue.poll();

                if (remaining[idx] <= quantum) {
                    time += remaining[idx];
                    remaining[idx] = 0;
                    completion[idx] = time;
                    isCompleted[idx] = true;
                    completed++;
                } else {
                    time += quantum;
                    remaining[idx] -= quantum;
                }

                // Add all processes that have arrived till now and not in queue
                for (int i = 0; i < n; i++) {
                    if (!inQueue[i] && !isCompleted[i] && arrival[i] <= time) {
                        queue.add(i);
                        inQueue[i] = true;
                    }
                }

                if (!isCompleted[idx]) {
                    queue.add(idx);
                }
            }

            int totalTAT = 0;
            int totalWT = 0;
            for (int i = 0; i < n; i++) {
                turnaround[i] = completion[i] - arrival[i];
                waiting[i] = turnaround[i] - burst[i];
                totalTAT += turnaround[i];
                totalWT += waiting[i];
            }

            String[] columns = { "Process", "Arrival Time", "Burst Time", "Completion Time", "Turnaround Time", "Waiting Time" };
            model.setDataVector(new Object[0][0], columns);

            for (int i = 0; i < n; i++) {
                model.addRow(new Object[]{
                        "P" + (i + 1), arrival[i], burst[i], completion[i], turnaround[i], waiting[i]
                });
            }

            model.addRow(new Object[]{"Total", "", "", "", totalTAT, totalWT});
            model.addRow(new Object[]{"Average", "", "", "", (double) totalTAT / n, (double) totalWT / n});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please ensure all values are correct.");
        }
    }
    void Prioritynp(){
        try {
            String[] arrivalStr = arrivalText.getText().split(",");
            String[] burstStr = bustText.getText().split(",");
            String[] priorityStr = priorityText.getText().split(",");

            int n = arrivalStr.length;
            int[] arrival = new int[n];
            int[] burst = new int[n];
            int[] priority = new int[n];
            int[] completion = new int[n];
            int[] turnaround = new int[n];
            int[] waiting = new int[n];
            boolean[] isCompleted = new boolean[n];

            for (int i = 0; i < n; i++) {
                arrival[i] = Integer.parseInt(arrivalStr[i].trim());
                burst[i] = Integer.parseInt(burstStr[i].trim());
                priority[i] = Integer.parseInt(priorityStr[i].trim());
            }

            int time = 0, completed = 0;

            while (completed != n) {
                int idx = -1;
                int minPriority = Integer.MAX_VALUE;

                for (int i = 0; i < n; i++) {
                    if (arrival[i] <= time && !isCompleted[i]) {
                        if (priority[i] < minPriority) {
                            minPriority = priority[i];
                            idx = i;
                        } else if (priority[i] == minPriority) {
                            if (arrival[i] < arrival[idx]) {
                                idx = i;
                            }
                        }
                    }
                }

                if (idx != -1) {
                    time += burst[idx];
                    completion[idx] = time;
                    isCompleted[idx] = true;
                    completed++;
                } else {
                    time++;
                }
            }

            int totalTAT = 0, totalWT = 0;

            for (int i = 0; i < n; i++) {
                turnaround[i] = completion[i] - arrival[i];
                waiting[i] = turnaround[i] - burst[i];
                totalTAT += turnaround[i];
                totalWT += waiting[i];
            }

            String[] columns = { "Process", "Arrival", "Burst", "Priority", "Completion", "TAT", "Waiting" };
            model.setDataVector(new Object[0][0], columns);

            for (int i = 0; i < n; i++) {
                model.addRow(new Object[]{
                        "P" + (i + 1), arrival[i], burst[i], priority[i], completion[i],
                        turnaround[i], waiting[i]
                });
            }

            model.addRow(new Object[]{
                    "Total", "", "", "", "", totalTAT, totalWT
            });
            model.addRow(new Object[]{
                    "Avg", "", "", "", "", (double) totalTAT / n, (double) totalWT / n
            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please ensure all values are correct.");
        }
    }
    void Priority(){
        try {
            String[] arrivalStr = arrivalText.getText().split(",");
            String[] burstStr = bustText.getText().split(",");
            String[] priorityStr = priorityText.getText().split(",");

            int n = arrivalStr.length;
            int[] arrival = new int[n];
            int[] burst = new int[n];
            int[] priority = new int[n];
            int[] remaining = new int[n];
            int[] completion = new int[n];
            int[] turnaround = new int[n];
            int[] waiting = new int[n];
            boolean[] isCompleted = new boolean[n];

            for (int i = 0; i < n; i++) {
                arrival[i] = Integer.parseInt(arrivalStr[i].trim());
                burst[i] = Integer.parseInt(burstStr[i].trim());
                priority[i] = Integer.parseInt(priorityStr[i].trim());
                remaining[i] = burst[i];
            }

            int time = 0, completed = 0;

            while (completed != n) {
                int idx = -1;
                int minPriority = Integer.MAX_VALUE;

                for (int i = 0; i < n; i++) {
                    if (arrival[i] <= time && remaining[i] > 0) {
                        if (priority[i] < minPriority) {
                            minPriority = priority[i];
                            idx = i;
                        } else if (priority[i] == minPriority && arrival[i] < arrival[idx]) {
                            idx = i;
                        }
                    }
                }

                if (idx != -1) {
                    remaining[idx]--;
                    time++;

                    if (remaining[idx] == 0) {
                        completion[idx] = time;
                        isCompleted[idx] = true;
                        completed++;
                    }
                } else {
                    time++;
                }
            }

            int totalTAT = 0, totalWT = 0;

            for (int i = 0; i < n; i++) {
                turnaround[i] = completion[i] - arrival[i];
                waiting[i] = turnaround[i] - burst[i];
                totalTAT += turnaround[i];
                totalWT += waiting[i];
            }

            String[] columns = {"Process", "Arrival", "Burst", "Priority", "Completion", "TAT", "Waiting"};
            model.setDataVector(new Object[0][0], columns);

            for (int i = 0; i < n; i++) {
                model.addRow(new Object[]{
                        "P" + (i + 1), arrival[i], burst[i], priority[i], completion[i],
                        turnaround[i], waiting[i]
                });
            }

            model.addRow(new Object[]{
                    "Total", "", "", "", "", totalTAT, totalWT
            });
            model.addRow(new Object[]{
                    //"Avg", "", "", "", "", (double) totalTAT / n, (double) totalWT / n
                    "Avg", "", "", "", "", String.format("%.1f", (double) totalTAT / n), String.format("%.1f", (double) totalWT / n)
            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please ensure all values are correct.");
        }
    }
    void fcf(){
        try {
            int headPosition = Integer.parseInt(headText.getText().trim());
            String[] queueStrings = queueText.getText().trim().split(",");
            int[] qu = new int[queueStrings.length];

            for (int i = 0; i < queueStrings.length; i++) {
                qu[i] = Integer.parseInt(queueStrings[i].trim());
            }

            int totalSeek = 0;
            int current = headPosition;
            StringBuilder calc = new StringBuilder();

            for (int i = 0; i < qu.length; i++) {
                calc.append("|").append(current).append("-").append(qu[i]).append("|");
                if (i < qu.length - 1) calc.append("+");
                totalSeek += Math.abs(current - qu[i]);
                current = qu[i];
            }

            // Final formatted result
            String result = "Total Seek Distance: " + calc + " = " + totalSeek;

            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Seek Time Calculation");
            model.addRow(new Object[]{result});

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    void SSTF(){
        try {
            int headPosition = Integer.parseInt(headText.getText().trim());
            String[] queueStrings = queueText.getText().trim().split(",");
            int[] requests = new int[queueStrings.length];

            for (int i = 0; i < queueStrings.length; i++) {
                requests[i] = Integer.parseInt(queueStrings[i].trim());
            }

            boolean[] visited = new boolean[requests.length];
            int totalSeek = 0;
            int current = headPosition;
            StringBuilder calc = new StringBuilder();

            for (int i = 0; i < requests.length; i++) {
                int minDistance = Integer.MAX_VALUE;
                int idx = -1;
                for (int j = 0; j < requests.length; j++) {
                    if (!visited[j]) {
                        int distance = Math.abs(current - requests[j]);
                        if (distance < minDistance) {
                            minDistance = distance;
                            idx = j;
                        }
                    }
                }

                visited[idx] = true;
                calc.append("|").append(current).append("-").append(requests[idx]).append("|");
                if (i < requests.length - 1) calc.append("+");
                totalSeek += Math.abs(current - requests[idx]);
                current = requests[idx];
            }

            String result = "Total Seek Distance: " + calc + " = " + totalSeek;

            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Seek Time Calculation");
            model.addRow(new Object[]{result});

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    void SCAN(){
        try {
            int headPosition = Integer.parseInt(headText.getText().trim());
            int totalTracks = Integer.parseInt(rangeText.getText().trim());
            String[] queueStrings = queueText.getText().trim().split(",");
            int[] requests = new int[queueStrings.length + 1];

            for (int i = 0; i < queueStrings.length; i++) {
                requests[i] = Integer.parseInt(queueStrings[i].trim());
            }

            requests[queueStrings.length] = headPosition;
            Arrays.sort(requests);

            int headIndex = 0;
            for (int i = 0; i < requests.length; i++) {
                if (requests[i] == headPosition) {
                    headIndex = i;
                    break;
                }
            }

            int totalSeek = 0;
            int current = headPosition;
            StringBuilder calc = new StringBuilder();

            // Move right and service all requests
            for (int i = headIndex + 1; i < requests.length; i++) {
                calc.append("|").append(current).append("-").append(requests[i]).append("|");
                totalSeek += Math.abs(current - requests[i]);
                current = requests[i];
                if (i < requests.length - 1 || headIndex > 0) calc.append("+");
            }

            // Move to the end of the track if not already there
            if (current != totalTracks - 1) {
                calc.append("|").append(current).append("-").append(totalTracks - 1).append("|");
                totalSeek += Math.abs(current - (totalTracks - 1));
                current = totalTracks - 1;
                if (headIndex > 0) calc.append("+");
            }

            // Move left and service all remaining requests
            for (int i = headIndex - 1; i >= 0; i--) {
                calc.append("|").append(current).append("-").append(requests[i]).append("|");
                totalSeek += Math.abs(current - requests[i]);
                current = requests[i];
                if (i > 0) calc.append("+");
            }

            String result = "Total Seek Distance: " + calc + " = " + totalSeek;

            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Seek Time Calculation");
            model.addRow(new Object[]{result});

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    void C_SCAN(){
        try {
            int headPosition = Integer.parseInt(headText.getText().trim());
            int totalTracks = Integer.parseInt(rangeText.getText().trim()); // Number of tracks, e.g., 256
            String[] queueStrings = queueText.getText().trim().split(",");
            int[] requests = new int[queueStrings.length + 1];

            for (int i = 0; i < queueStrings.length; i++) {
                requests[i] = Integer.parseInt(queueStrings[i].trim());
            }

            requests[queueStrings.length] = headPosition; // Include head in the list
            Arrays.sort(requests);

            int headIndex = 0;
            for (int i = 0; i < requests.length; i++) {
                if (requests[i] == headPosition) {
                    headIndex = i;
                    break;
                }
            }

            int totalSeek = 0;
            int current = headPosition;
            StringBuilder calc = new StringBuilder();

            // Move right (towards max track)
            for (int i = headIndex + 1; i < requests.length; i++) {
                calc.append("|").append(current).append("-").append(requests[i]).append("|+");
                totalSeek += Math.abs(current - requests[i]);
                current = requests[i];
            }

            // Move to end (if needed)
            if (current != totalTracks - 1) {
                calc.append("|").append(current).append("-").append(totalTracks - 1).append("|+");
                totalSeek += Math.abs(current - (totalTracks - 1));
                current = totalTracks - 1;
            }

            // Move to beginning
            calc.append("|").append(current).append("-0|+");
            totalSeek += current;
            current = 0;

            // Move right again through requests before head
            for (int i = 0; i < headIndex; i++) {
                calc.append("|").append(current).append("-").append(requests[i]).append("|");
                if (i < headIndex - 1) calc.append("+");
                totalSeek += Math.abs(current - requests[i]);
                current = requests[i];
            }

            // Trim trailing '+'
            if (calc.charAt(calc.length() - 1) == '+') {
                calc.setLength(calc.length() - 1);
            }

            String result = "Total Seek Distance: " + calc + " = " + totalSeek;

            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Seek Time Calculation");
            model.addRow(new Object[]{result});

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    void LOOK(){
        try {
            int headPosition = Integer.parseInt(headText.getText().trim());
            String[] queueStrings = queueText.getText().trim().split(",");
            int[] requests = new int[queueStrings.length + 1];

            for (int i = 0; i < queueStrings.length; i++) {
                requests[i] = Integer.parseInt(queueStrings[i].trim());
            }

            requests[queueStrings.length] = headPosition;
            Arrays.sort(requests);

            int headIndex = 0;
            for (int i = 0; i < requests.length; i++) {
                if (requests[i] == headPosition) {
                    headIndex = i;
                    break;
                }
            }

            int totalSeek = 0;
            int current = headPosition;
            StringBuilder calc = new StringBuilder();

            // Move right and service all requests
            for (int i = headIndex + 1; i < requests.length; i++) {
                calc.append("|").append(current).append("-").append(requests[i]).append("|");
                if (i < requests.length - 1) calc.append("+");
                totalSeek += Math.abs(current - requests[i]);
                current = requests[i];
            }

            // Then go left and service remaining
            for (int i = headIndex - 1; i >= 0; i--) {
                calc.append("+|").append(current).append("-").append(requests[i]).append("|");
                totalSeek += Math.abs(current - requests[i]);
                current = requests[i];
            }

            String result = "Total Seek Distance: " + calc + " = " + totalSeek;

            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Seek Time Calculation");
            model.addRow(new Object[]{result});

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    void C_LOOK(){
        try {
            int headPosition = Integer.parseInt(headText.getText().trim());
            String[] queueStrings = queueText.getText().trim().split(",");
            int[] requests = new int[queueStrings.length + 1];

            for (int i = 0; i < queueStrings.length; i++) {
                requests[i] = Integer.parseInt(queueStrings[i].trim());
            }

            requests[queueStrings.length] = headPosition; // include head
            Arrays.sort(requests);

            int headIndex = 0;
            for (int i = 0; i < requests.length; i++) {
                if (requests[i] == headPosition) {
                    headIndex = i;
                    break;
                }
            }

            int totalSeek = 0;
            int current = headPosition;
            StringBuilder calc = new StringBuilder();

            // Move right (higher than head)
            for (int i = headIndex + 1; i < requests.length; i++) {
                calc.append("|").append(current).append("-").append(requests[i]).append("|+");
                totalSeek += Math.abs(current - requests[i]);
                current = requests[i];
            }

            // Jump to the lowest request (simulate circular movement)
            if (headIndex > 0) {
                int jumpTo = requests[0];
                calc.append("|").append(current).append("-").append(jumpTo).append("|+");
                totalSeek += Math.abs(current - jumpTo);
                current = jumpTo;
            }

            // Move right again through remaining lower values
            for (int i = 0; i < headIndex; i++) {
                calc.append("|").append(current).append("-").append(requests[i]).append("|");
                if (i < headIndex - 1) calc.append("+");
                totalSeek += Math.abs(current - requests[i]);
                current = requests[i];
            }

            // Remove last '+' if exists
            if (calc.length() > 0 && calc.charAt(calc.length() - 1) == '+') {
                calc.setLength(calc.length() - 1);
            }

            String result = "Total Seek Distance: " + calc + " = " + totalSeek;

            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Seek Time Calculation");
            model.addRow(new Object[]{result});

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    void FIFO(){
        try {
            String[] referenceString = queueText.getText().trim().split(","); // string holds page reference string
            int frameCount = Integer.parseInt(frameText.getText().trim());  // frame_no holds number of frames

            Queue<Integer> fifoQueue = new LinkedList<>();
            StringBuilder calc = new StringBuilder();

            int pageFaults = 0;

            for (String s : referenceString) {
                int page = Integer.parseInt(s.trim());

                if (!fifoQueue.contains(page)) {
                    if (fifoQueue.size() == frameCount) {
                        fifoQueue.poll(); // Remove oldest page
                    }
                    fifoQueue.add(page);
                    pageFaults++;
                    calc.append(page).append(" (F), ");
                } else {
                    calc.append(page).append(" (H), ");
                }
            }

            // Clean up trailing comma
            if (calc.length() > 2) {
                calc.setLength(calc.length() - 2);
            }

            int totalPages = referenceString.length;
            double missRatio = (double) pageFaults / totalPages;
            double hitRatio = 1.0 - missRatio;

            // Display in table
            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("FIFO Page Replacement");

            model.addRow(new Object[]{"Calculation: " + calc.toString()});
            model.addRow(new Object[]{"Number of Page Faults = " + pageFaults});
            model.addRow(new Object[]{
                    "Miss Ratio = " + pageFaults + " / " + totalPages + " = " + String.format("%.2f", missRatio)
            });
            model.addRow(new Object[]{
                    "Hit Ratio = 1 - " + String.format("%.2f", missRatio) + " = " + String.format("%.2f", hitRatio)
            });

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    void LRU(){
        try {
            String[] referenceString = queueText.getText().trim().split(","); // string holds page reference string
            int frameCount = Integer.parseInt(frameText.getText().trim());  // frame_no holds number of frames

            List<Integer> frames = new ArrayList<>();
            StringBuilder calc = new StringBuilder();
            int pageFaults = 0;

            for (String s : referenceString) {
                int page = Integer.parseInt(s.trim());

                if (!frames.contains(page)) {
                    if (frames.size() == frameCount) {
                        frames.remove(0); // Remove the least recently used (first) page
                    }
                    frames.add(page);
                    pageFaults++;
                    calc.append(page).append(" (F), ");
                } else {
                    // Move the page to the most recently used (end of list)
                    frames.remove((Integer) page);
                    frames.add(page);
                    calc.append(page).append(" (H), ");
                }
            }

            // Remove the last comma and space
            if (calc.length() > 2) {
                calc.setLength(calc.length() - 2);
            }

            int totalPages = referenceString.length;
            double missRatio = (double) pageFaults / totalPages;
            double hitRatio = 1.0 - missRatio;

            // Format to 2 decimal places and include the formulas
            String missFormula = pageFaults + "/" + totalPages + " = " + String.format("%.2f", missRatio);
            String hitFormula = "1 - " + String.format("%.2f", missRatio) + " = " + String.format("%.2f", hitRatio);

            // Display in table
            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("LRU Page Replacement");

            model.addRow(new Object[]{"Calculation: " + calc.toString()});
            model.addRow(new Object[]{"Number of Page Faults = " + pageFaults});
            model.addRow(new Object[]{"Miss Ratio = " + missFormula});
            model.addRow(new Object[]{"Hit Ratio = " + hitFormula});

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    void Optimal(){
        try {
            String[] referenceString = queueText.getText().trim().split(","); // string holds page reference string
            int frameCount = Integer.parseInt(frameText.getText().trim());  // frame_no holds number of frames

            List<Integer> frames = new ArrayList<>();
            StringBuilder calc = new StringBuilder();
            int pageFaults = 0;

            for (int i = 0; i < referenceString.length; i++) {
                int page = Integer.parseInt(referenceString[i].trim());

                if (!frames.contains(page)) {
                    if (frames.size() == frameCount) {
                        int indexToReplace = -1;
                        int farthest = i + 1;

                        for (int j = 0; j < frames.size(); j++) {
                            int nextUse = -1;
                            for (int k = i + 1; k < referenceString.length; k++) {
                                if (Integer.parseInt(referenceString[k].trim()) == frames.get(j)) {
                                    nextUse = k;
                                    break;
                                }
                            }

                            if (nextUse == -1) {
                                indexToReplace = j;
                                break;
                            } else if (nextUse > farthest) {
                                farthest = nextUse;
                                indexToReplace = j;
                            }
                        }

                        if (indexToReplace == -1) indexToReplace = 0; // fallback

                        frames.remove(indexToReplace);
                    }

                    frames.add(page);
                    pageFaults++;
                    calc.append(page).append(" (F), ");
                } else {
                    calc.append(page).append(" (H), ");
                }
            }

            // Remove the last comma and space
            if (calc.length() > 2) {
                calc.setLength(calc.length() - 2);
            }

            int totalPages = referenceString.length;
            double missRatio = (double) pageFaults / totalPages;
            double hitRatio = 1.0 - missRatio;

            // Format to 2 decimal places and include the formulas
            String missFormula = pageFaults + "/" + totalPages + " = " + String.format("%.2f", missRatio);
            String hitFormula = "1 - " + String.format("%.2f", missRatio) + " = " + String.format("%.2f", hitRatio);

            // Display in table
            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Optimal Page Replacement");

            model.addRow(new Object[]{"Calculation: " + calc.toString()});
            model.addRow(new Object[]{"Number of Page Faults = " + pageFaults});
            model.addRow(new Object[]{"Miss Ratio = " + missFormula});
            model.addRow(new Object[]{"Hit Ratio = " + hitFormula});

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    void First_Fit(){
        try {
            String[] blockSizeStrings = memoryText.getText().trim().split(",");
            String[] processSizeStrings = processText.getText().trim().split(",");

            int numBlocks = blockSizeStrings.length;
            int numProcesses = processSizeStrings.length;

            int[] blockSizes = new int[numBlocks];
            boolean[] blockUsed = new boolean[numBlocks];
            int[] processSizes = new int[numProcesses];
            int[] allocation = new int[numProcesses];
            String[] fragmentation = new String[numProcesses];

            for (int i = 0; i < numBlocks; i++) {
                blockSizes[i] = Integer.parseInt(blockSizeStrings[i].trim());
            }
            for (int i = 0; i < numProcesses; i++) {
                processSizes[i] = Integer.parseInt(processSizeStrings[i].trim());
                allocation[i] = -1;
                fragmentation[i] = "";
            }

            int totalInternalFrag = 0;

            for (int i = 0; i < numProcesses; i++) {
                for (int j = 0; j < numBlocks; j++) {
                    if (!blockUsed[j] && blockSizes[j] >= processSizes[i]) {
                        allocation[i] = j;
                        blockUsed[j] = true;

                        int frag = blockSizes[j] - processSizes[i];
                        totalInternalFrag += frag;
                        fragmentation[i] = String.valueOf(frag);
                        break;
                    }
                }
            }

            // Set up the table
            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Process No.");
            model.addColumn("Process Size");
            model.addColumn("Block Size");
            model.addColumn("Internal Fragmentation");

            for (int i = 0; i < numProcesses; i++) {
                if (allocation[i] != -1) {
                    model.addRow(new Object[]{
                            i + 1,
                            processSizes[i],
                            blockSizes[allocation[i]],
                            fragmentation[i]
                    });
                } else {
                    model.addRow(new Object[]{
                            i + 1,
                            processSizes[i],
                            "Not Allocated",
                            "N/A"
                    });
                }
            }

            // Add unused blocks as individual rows with "(unused)"
            for (int i = 0; i < numBlocks; i++) {
                if (!blockUsed[i]) {
                    totalInternalFrag += blockSizes[i];
                    model.addRow(new Object[]{
                            "", "", blockSizes[i] + " (unused)", blockSizes[i]
                    });
                }
            }

            // Add total internal fragmentation row
            model.addRow(new Object[]{
                    "Total", "", "", totalInternalFrag
            });

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    void Best_Fit(){
        try {
            String[] blockSizeStrings = memoryText.getText().trim().split(",");
            String[] processSizeStrings = processText.getText().trim().split(",");

            int numBlocks = blockSizeStrings.length;
            int numProcesses = processSizeStrings.length;

            int[] blockSizes = new int[numBlocks];
            boolean[] blockUsed = new boolean[numBlocks];
            int[] processSizes = new int[numProcesses];
            int[] allocation = new int[numProcesses];
            int[] internalFrag = new int[numProcesses];

            for (int i = 0; i < numBlocks; i++) {
                blockSizes[i] = Integer.parseInt(blockSizeStrings[i].trim());
            }
            for (int i = 0; i < numProcesses; i++) {
                processSizes[i] = Integer.parseInt(processSizeStrings[i].trim());
                allocation[i] = -1;
            }

            int totalInternalFrag = 0;

            // Best Fit Allocation
            for (int i = 0; i < numProcesses; i++) {
                int bestIdx = -1;
                for (int j = 0; j < numBlocks; j++) {
                    if (!blockUsed[j] && blockSizes[j] >= processSizes[i]) {
                        if (bestIdx == -1 || blockSizes[j] < blockSizes[bestIdx]) {
                            bestIdx = j;
                        }
                    }
                }

                if (bestIdx != -1) {
                    allocation[i] = bestIdx;
                    blockUsed[bestIdx] = true;
                    internalFrag[i] = blockSizes[bestIdx] - processSizes[i];
                    totalInternalFrag += internalFrag[i];
                }
            }

            // Prepare table
            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Process No.");
            model.addColumn("Process Size");
            model.addColumn("Block Size");
            model.addColumn("Internal Fragmentation");

            for (int i = 0; i < numProcesses; i++) {
                if (allocation[i] != -1) {
                    model.addRow(new Object[]{
                            i + 1,
                            processSizes[i],
                            blockSizes[allocation[i]],
                            internalFrag[i]
                    });
                } else {
                    model.addRow(new Object[]{
                            i + 1,
                            processSizes[i],
                            "Not Allocated",
                            "N/A"
                    });
                }
            }

            // Add unused blocks one row at a time
            for (int i = 0; i < numBlocks; i++) {
                if (!blockUsed[i]) {
                    totalInternalFrag += blockSizes[i];
                    model.addRow(new Object[]{
                            "",
                            "",
                            blockSizes[i] + " (unused)",
                            blockSizes[i]
                    });
                }
            }

            // Final total row
            model.addRow(new Object[]{
                    "Total",
                    "",
                    "",
                    totalInternalFrag
            });

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    void Worst_Fit(){
        try {
            String[] blockSizeStrings = memoryText.getText().trim().split(",");
            String[] processSizeStrings = processText.getText().trim().split(",");

            int numBlocks = blockSizeStrings.length;
            int numProcesses = processSizeStrings.length;

            int[] blockSizes = new int[numBlocks];
            boolean[] blockUsed = new boolean[numBlocks];
            int[] processSizes = new int[numProcesses];
            int[] allocation = new int[numProcesses];
            int[] internalFrag = new int[numProcesses];

            for (int i = 0; i < numBlocks; i++) {
                blockSizes[i] = Integer.parseInt(blockSizeStrings[i].trim());
            }
            for (int i = 0; i < numProcesses; i++) {
                processSizes[i] = Integer.parseInt(processSizeStrings[i].trim());
                allocation[i] = -1;
            }

            int totalInternalFrag = 0;

            // Worst Fit Allocation
            for (int i = 0; i < numProcesses; i++) {
                int worstIdx = -1;
                for (int j = 0; j < numBlocks; j++) {
                    if (!blockUsed[j] && blockSizes[j] >= processSizes[i]) {
                        if (worstIdx == -1 || blockSizes[j] > blockSizes[worstIdx]) {
                            worstIdx = j;
                        }
                    }
                }

                if (worstIdx != -1) {
                    allocation[i] = worstIdx;
                    blockUsed[worstIdx] = true;
                    internalFrag[i] = blockSizes[worstIdx] - processSizes[i];
                    totalInternalFrag += internalFrag[i];
                }
            }

            // Prepare table
            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Process No.");
            model.addColumn("Process Size");
            model.addColumn("Block Size");
            model.addColumn("Internal Fragmentation");

            for (int i = 0; i < numProcesses; i++) {
                if (allocation[i] != -1) {
                    model.addRow(new Object[]{
                            i + 1,
                            processSizes[i],
                            blockSizes[allocation[i]],
                            internalFrag[i]
                    });
                } else {
                    model.addRow(new Object[]{
                            i + 1,
                            processSizes[i],
                            "Not Allocated",
                            "N/A"
                    });
                }
            }

            // Add unused blocks one row at a time
            for (int i = 0; i < numBlocks; i++) {
                if (!blockUsed[i]) {
                    totalInternalFrag += blockSizes[i];
                    model.addRow(new Object[]{
                            "",
                            "",
                            blockSizes[i] + " (unused)",
                            blockSizes[i]
                    });
                }
            }

            // Final total row
            model.addRow(new Object[]{
                    "Total",
                    "",
                    "",
                    totalInternalFrag
            });

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your values.");
        }
    }
    }