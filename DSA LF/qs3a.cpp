#include <iostream>
using namespace std;

struct node
{
  int var;
  node *left,*right;
};
class bin_search_tree
{
   private :
	    node *ptr;
   public  :
	    node *root;
	    int value;
	    bin_search_tree();
	    void ch();
	    void searchTree(node *);
	    void trev(node *);
};

int main()
{
  char ch;
  bin_search_tree obj;
  while( 4 )
  {
    obj.ch();
    cin >> ch;
    switch(ch)
     {
       case '1':
		cout<<"\n Enter value to add in a tree... \n";
		cin>>obj.value;
		obj.searchTree( obj.root );
		break;
        case '2':
		obj.trev(obj.root);
		break;
       case '3':
		exit(0);
		break;
       default :
		exit(0);
		break;
     }
  }
}

bin_search_tree :: bin_search_tree()
{
  root=ptr=NULL;
}


void bin_search_tree :: searchTree(node *ptr)
{
  if( root==NULL )
   {
     ptr=new node;
     ptr->var = value;
     ptr->left=NULL;
     ptr->right=NULL;
     root=ptr;
     return;
   }

  if( ptr->var==value )
   {
      cout<<" \n Given value is already present in tree.\n";
      return;
    }
  if(ptr->var > value)
   {
      if( ptr->left!=NULL )
       {
		 searchTree(ptr->left);
		 return;
       }
      else
       {
	 ptr->left=new node;
	 ptr->left->var = value;
	 ptr->left->left=NULL;
	 ptr->left->right=NULL;
	 return;
       }
   }
  if(ptr->var < value)
   {
      if( ptr->right!=NULL )
       {
		 searchTree( ptr->right );
		 return;
       }
      else
       {
	 ptr->right=new node;
	 ptr->right->var = value;
	 ptr->right->left=NULL;
	 ptr->right->right=NULL;
	 return;
       }
   }

} 

void bin_search_tree :: ch()
{
 
 cout<<"\n Enter any of choices.\n";
 cout<<"\n 1 : Inserting node in BST.\n";
 cout<<"\n 2 : Print the whole BST .\n";
 cout<<"\n 3 : Quit the Program.\n";
}
void bin_search_tree :: trev(node *ptr)
{
  if(root==NULL)
    {
	cout<<" Tree is empty.\n";
	return;
    }
  if( ptr->left!=NULL )
    		 trev(ptr->left);
  cout<<ptr->var<<"  ";
  if( ptr->right!=NULL )
		 trev(ptr->right);
  return;
}


