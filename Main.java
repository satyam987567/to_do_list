import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;
class Users_task {
    String task_description;
    boolean task_status;
    LocalDate task_date;
    int id;

    public Users_task(String s1,LocalDate d,int id1){
        task_description=s1;
        task_date=d;
        task_status=false;
        id=id1;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Users_task> tasks=new ArrayList<>();
        int id1=0;
        Scanner myObj = new Scanner(System.in);
        System.out.println("1: add task");
        System.out.println("2: delete date");
        System.out.println("3: group by date");
        System.out.println("4: mark task completed");
        System.out.println("5: search task based on first word");
        System.out.println("6: show all task");
        while(true){
            System.out.println("enter operation you want to do:");
            int ab=myObj.nextInt();
            switch(ab){
                case 1:
                    id1++;
                    System.out.println("add task");
                    System.out.println("add description");
                    String description=myObj.next();

                    LocalDate date=LocalDate.now();

                    Users_task task = new Users_task(description, date,id1);
                    tasks.add(task);
                    System.out.println(tasks.size());
                    break;
                case 2:
                    System.out.println("delete date");
                    System.out.println("enter id to be deleted");
                    int id2= myObj.nextInt();
                    for(int i=0;i< tasks.size();i++){
                        Users_task temp = tasks.get(i);
                        if(temp.id==id2){
                            tasks.remove(i);
                            System.out.println("deleted!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("group by date");
                    System.out.println("enter date to be group");
                    String temp_task_date=myObj.next();
                    for(int i=0;i< tasks.size();i++) {
                        Users_task temp = tasks.get(i);
                        if (temp.task_date.equals(temp_task_date)) {
                            System.out.println(temp.task_description);
                        }
                    }
                    break;
                case 4:
                    System.out.println("mark task completed");
                    System.out.println("enter id to be deleted");
                    int id3= myObj.nextInt();
                    for(int i=0;i< tasks.size();i++){
                        Users_task temp = tasks.get(i);
                        if(temp.id==id3){
                            temp.task_status=true;
                        }
                    }
                    break;
                case 5:
                    System.out.println("search task based on first word");
                    System.out.println("enter word");
                    String task_word= myObj.nextLine();
                    for(int i=0;i< tasks.size();i++){
                        Users_task temp = tasks.get(i);
                        if(temp.task_description.startsWith(task_word)){
                            System.out.println(temp.task_description);
                        }
                    }
                    break;
                case 6:
                    for(int i=0;i< tasks.size();i++){
                        Users_task temp = tasks.get(i);
                        System.out.println(temp.task_description);
                    }
                    break;
                default:
                    System.out.println("Invalid key");

            }
        }




    }
}