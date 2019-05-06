package DateStructure.list;


/**
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
class MyLinkedList {
//*******************关键在缓冲节点，不能直接用原来节点移动！**********
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    Node head = new Node(0);
    int size = 0;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node temp = head;
        if(index <0 || index >=size){
            return  -1;
        }else{
            for(int i = 0;i<=index;i++){
                temp = temp.next;
            }
            return temp.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node temp = head;
        Node node = new Node(val);
        if(index <0 || index >size){
            return ;
        }
        if(index == size ){
            while(temp.next != null) temp = temp.next;
            temp.next = node;
            size++;
            return ;
        }
        for(int i = 0;i <index;i++ ){
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node temp = head;
        if(index <0 || index >=size){
            return ;
        }
        for(int i = 0;i < index;i++ ){
            temp = temp.next;
        }
        if(temp != null)
            temp.next = temp.next.next;
        size--;
    }
    public void show(){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.next.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        System.out.println(myLinkedList.get(0));
        myLinkedList.addAtTail(3);
        System.out.println(myLinkedList.get(1));
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(1));

    }
}