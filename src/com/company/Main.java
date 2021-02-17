package com.company;

import java.util.Scanner;

class Node {
    Node next;
    int data;

    Node(int data){
        this.data = data;
    }
}

class LinkedListQueue {
    Node front;
    Node rear;

    LinkedListQueue(){
        front = null;
        rear = null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void enQueue(Node node){
        if(front == null){
            front = node;
            rear = node;
        }else{
            rear.next = node;
            rear = node;
        }
    }

    public Node deQueue(){
        if(isEmpty()){
            System.out.println("Queue is EMPTY\n");
            return null;
        }else{
            Node pop = front;
            if(front.next != null) {
                front = front.next;
            }else{
                front = null;
            }

            return pop;
        }
    }

    public void printQueue(){
        Node tmp = front;

        while(tmp != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 큐 생성 & 초기화
        LinkedListQueue queue = new LinkedListQueue();

        // 큐 정보 입력
        System.out.println("\nMENU (1: enQueue | 2: deQueue | 3: print queue | -1: quit)\n");
        int check;
        do{
            System.out.print("what do you want? ");
            check = input.nextInt();

            // queue 삽입
            if(check == 1) {
                System.out.print("Input queue element: ");
                int tmp = input.nextInt();
                Node node = new Node(tmp);
                queue.enQueue(node);
            } // queue 삭제
            else if(check == 2) {
                Node node = queue.deQueue();
                if (node != null) {
                    System.out.println("Get element from queue: " + node.data);
                }
            } // 출력
            else if(check == 3){
                queue.printQueue();
            } // 종료
            else if(check == -1){
                System.out.println("exit...");
            } // 예외
            else{
                System.out.println("Command not found.\n");
            }

        } while(check != -1);
    }
}
