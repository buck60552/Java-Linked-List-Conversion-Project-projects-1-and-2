public class linkedList
{
	//Private variables
	private Node head;		//Reference to the first node in the list
	
	//LinkedList Constructor Method
	public linkedList()
	{
		head = null;		//Creates an empty list
	}
	
	//Name		: insertFront
	//Behavior	: insert a new node in front of list
	//Parameters: a Node
	//Return	: nothing
	public void insertFront(Node v)
	{
		if (head == null)
			head = v;		//Inserts new node into list if list is empty
		else
		{					
			v.setNext(head);	//Sets next to the head of the list and replaces head with new node
			head = v;
		}
	}
	
	//Name		: search
	//Behavior	: search for a Node in the list
	//Parameters: a String
	//Return	: a Node
	public String search(Node target)
	{
		//Start search at the front of the list
		Node current = head;
		
		//Check for reaching the end of the list
		while (current != null)
		{
			if (current.getData() == target.getData())
			{
				return current.getData();	//If target Node has been found
			}
			current = current.getNext();	//Advance to the next Node
		}
		return null;	//If target Node has not been found
	}
	
	//Name		: removeFirstNode
	//Behavior	: remove node at front of list
	//Parameters: nothing
	//Return	: nothing
	public void removeFirstNode()
	{
		//Check for if the list is empty
		if (head == null)
		{
			System.out.println("Error: List is empty.");
			return;
		}
		else
		{
			Node t = head;
			head = head.getNext();	//Change head to next Node
			t.setNext(null);		//Detach Node t from list
			t = null; 				//Recycle Node object
		}
	}
	
	public void removeAnyNode(Node target)
    {
        //Node variables to move through the list
        Node current = head;
        Node previous = null;

        //Check for end of list
        while ((current != null) && (current.getData() != target.getData()))
        {
            previous = current;
            current = current.getNext();
        }
        if (current == null)    //Failed to find target Node
            return;                //Stops method
        if (previous == null)
        {
            Node t = head;
            head = head.getNext();
            t.setNext(null);
            t = null;
        }
        else
        {
            previous.setNext(current.getNext());
            current.setNext(null);
            current = null;
        }
    }
	//Name		: removeNode
	//Behavior	: remove a node from list
	//Parameters: a Node
	//Return	: nothing
	
}