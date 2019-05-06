package DateStructure.list;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 节点结构
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }


  }

/**
 * 带头节点的链表
 */
class List{
      static ListNode head = new ListNode(0);

      public  void add(int value){
          ListNode temp = head;
          while(temp.next != null){
              temp = temp.next;
          }
          temp.next = new ListNode(value);

      }
      public void show(){
          ListNode temp = head.next;
          while(temp != null){
              System.out.println(temp.val);
              temp = temp.next;
          }
      }
}

class ListTest{
  @Test
    public static void main(String[] args) {
        List list = new List();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.show();



    }
}


class Solution {

    /**
     * 反转一个单链表。
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 堆栈实现依然需要改变next指向难以实现！即543212345循环！
     * 此处用首插
     */
    public ListNode reverseList(ListNode head) {
        ListNode temp = new ListNode(0);
        while(head != null){
            ListNode t = head;
            System.out.println(head.val);
            t.next = temp.next;
            temp.next = t;

            head = head.next;
        }
        return temp.next;
    }

    /**
     * 用链表方式相加两个倒序表示的数字
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        ListNode temp = head;
        while(l1 != null && l2 !=null){
            if((l1.val + l2.val + temp.next.val) < 10)
            {
                temp.next = new ListNode(l1.val + l2.val + temp.next.val);
                temp.next.next = new ListNode(0);
            }else {
                temp.next = new ListNode((l1.val + l2.val + temp.next.val)%10);
                temp.next.next = new ListNode(1);
            }
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }
        //While !  While!  循环！
        while( l1 ==null && l2 != null){
            if((l2.val + temp.next.val) < 10) {
                temp.next = new ListNode(l2.val + temp.next.val);
                temp.next.next = new ListNode(0);
            }
            else {
                temp.next = new ListNode((l2.val + temp.next.val)%10);
                temp.next.next = new ListNode(1);
            }
            l2 = l2.next;
            temp = temp.next;
        }
        while( l2 == null && l1 != null){
            if((l1.val + temp.next.val) < 10) {
                temp.next = new ListNode(l1.val + temp.next.val);
                temp.next.next = new ListNode(0);
            }
            else {
                temp.next = new ListNode((l1.val + temp.next.val)%10);
                temp.next.next = new ListNode(1);
            }
            l1 = l1.next;
            temp = temp.next;
        }
        if(temp.next.val == 0) {
            temp.next = null;
        }
        return head.next;
    }
    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;


            }else{
                node.next = l2;
                node = node.next;
                l2 = l2.next;}
        }
        if(l1 == null && l2 !=null){
            node.next = l2;
            node = node.next;
            l2 = l2.next;      }
        if(l2 == null && l1 !=null){
            node.next = l1;
            node = node.next;
            l1 = l1.next;      }
        return temp.next;
    }

    /*******************************************
     *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表
     *给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public ListNode swapPairs(ListNode head) {

        //终止条件：链表只剩一个节点或者没节点了，没得交换了。返回的是已经处理好的链表
        if(head == null || head.next == null){
            return head;
        }
        //一共三个节点:head, next, swapPairs(next.next)
        //下面的任务便是交换这3个节点中的前两个节点
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        //根据第二步：返回给上一级的是当前已经完成交换后，即处理好了的链表部分
        return next;
    }

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp !=null && temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }

        return head;
    }

    /**
     * 给定一个链表，判断链表中是否有环。
     */
    public boolean hasCycle(ListNode head) {
       Set<ListNode> set = new HashSet();
       while (head != null){
           if(!set.contains(head)){
               set.add(head);
           }else {
               return true;
           }
           head = head.next;
       }
        return false;
    }

    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headA = headA.next;
        }
        return null;
    }

    /**
     * 删除链表中等于给定值 val 的所有节点。
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        //加表头  删第一个元素容易
        ListNode temp = new ListNode(0);
        ListNode t = temp;
        temp.next = head;
        while(temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return t.next;
    }





}

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
class DeleteSolution {

    //两次遍历  未使用头结点
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len;
        if(head == null) {
            len = 0;
            return head = null;
        }else{
            len = 1;
        }
        ListNode temp=head;
        while(head.next!=null){
            len++;
            head=head.next;
        }

        head=temp;
        if(len - n == 0){
            return head=head.next;
        }
        for(int i=1;i<len-n;i++){
            head=head.next;
        }
        if(n == 1){
            head.next = null;
        }else {
            head.next = head.next.next;
        }
        head=temp;
        return head;
    }

    //一次遍历  使用头结点
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode fast = first;
        ListNode temp = first;
        for(int i = 0;i < n+1 ;i++){
            fast=fast.next;
        }
        while(fast != null){
            fast=fast.next;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return first.next;

    }

}
