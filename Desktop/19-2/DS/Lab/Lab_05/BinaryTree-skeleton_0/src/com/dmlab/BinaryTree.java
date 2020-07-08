package com.dmlab;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<? super Key>, E> {

	class Node {
		private Key mKey;
		private E mValue;

		private Node mLeft;
		private Node mRight;

		public Node(Key key, E value) {
			mKey = key;
			mValue = value;
			mLeft = null;
			mRight = null;
		}

		public Key getKey() {
			return mKey;
		}

		public E getValue() {
			return mValue;
		}

		/**
		 * Insert a node to the subtree, the root of which is this node.
		 * If the subtree already has node with the given key in the param,
		 * replace the value of the node in the subtree.
		 * Please compare keys using compareTo method.
		 * <p>
		 * e.g. when "int compare = KEY0.compareTo(KEY1)"
		 * if compare == 0, this means KEY0 is equal to KEY1
		 * if compare > 0, KEY0 > KEY1
		 * if compare < 0, KEY0 < KEY1
		 *
		 * @param key
		 * @param value
		 * @return None
		 */
		public void insert(Key key, E value) {
			// TODO: Fill this function

			/*
			if(this == null) {
				Node nNode = new Node(key,value);
				this = nNode;

			}*/

			// in case, this node is not empty
			int compare = this.getKey().compareTo(key);
			if (compare == 0) {
				// same key
				this.mValue = value;
			} else if (compare < 0) {
				if (this.mLeft == null) {
					this.mLeft = new Node(key, value);
				} else {
					this.mLeft.insert(key, value);
				}
			} else { // compare > 0
				//right
				if (this.mRight == null) {
					this.mRight = new Node(key, value);
				} else {
					this.mRight.insert(key, value);
				}
			}

		}

		/**
		 * Find the value of item by the key in the subtree, the root of which is this node.
		 *
		 * @param key
		 * @return the value of item matched with the given key.
		 * null, if there is no matching node in this subtree.
		 */
		public E find(Key key) {
			// TODO: Fill this function
			int compare = this.getKey().compareTo(key);

			if (compare == 0) {
				return this.getValue();
			} else if (compare < 0) {
				if (this.mLeft == null) {
					return null;
				} else {
					return this.mLeft.find(key);
				}
			} else { // compare > 0
				//right
				if (this.mRight == null) {
					return null;
				} else {
					return this.mRight.find(key);
				}
			}


		}

		@Override
		public String toString() {
			return "[" + String.valueOf(mKey) + ":" + String.valueOf(mValue) + "]";
		}

		/**
		 * Traverse with the preorder in this subtree.
		 *
		 * @return The String to be printed-out which contains series of nodes as the preorder traversal.
		 */
		public String preorder() {
			// TODO: Fill this function
			// use Node.toString
			StringBuilder sb = new StringBuilder();
			sb.append(this.toString());
			if (this.mLeft != null) sb.append(this.mLeft.preorder());
			if (this.mRight != null) sb.append(this.mRight.preorder());

			return sb.toString();
		}

		/**
		 * Traverse with the inorder in this subtree.
		 *
		 * @return The String to be printed-out which contains series of nodes as the inorder traversal.
		 */
		public String inorder() {
			// TODO: Fill this function
			StringBuilder sb = new StringBuilder();
			if (this.mLeft != null) sb.append(this.mLeft.preorder());
			sb.append(this.toString());
			if (this.mRight != null) sb.append(this.mRight.preorder());

			return sb.toString();
		}

		/**
		 * Traverse with the postorder in this subtree.
		 *
		 * @return The String to be printed-out which contains series of nodes as the postorder traversal.
		 */
		public String postorder() {
			// TODO: Fill this function
			StringBuilder sb = new StringBuilder();
			if (this.mLeft != null) sb.append(this.mLeft.preorder());
			if (this.mRight != null) sb.append(this.mRight.preorder());
			sb.append(this.toString());

			return sb.toString();
		}

		/**
		 * Find the height of this subtree
		 *
		 * @return height
		 */
		public boolean iscomplete(Node root) {
//            // TODO: Fill this function
//			int sum = 0;
//			for (int i = 0; i < this.height(); i++) {
//				sum += (int)Math.pow(2, i);
//			}
//
//
//			return true;
			return true;
		}

		/**
		 * Find the height of this subtree
		 *
		 * @return height
		 */
		public int height() {
			// TODO: Fill this function
			int height = 0;
			if (this.getKey() == null) return height;
			height++;
			int lHeight = 0, rHeight = 0;
			if (this.mLeft != null) {
				lHeight += mLeft.height();
			}
			if (this.mRight != null) {
				rHeight += mRight.height();
			}
			return (lHeight >= rHeight) ? (height + lHeight) : (height + rHeight);

		}

		public Node findMin() {
			if (mLeft == null)
				return this;
			else
				return mLeft.findMin();
		}

		/**
		 * Delete a node,the key of which match with the key given as param, from this subtree.
		 * You may need to define new method to find minimum of the subtree.
		 *
		 * @return the node of which parent needs to point after the deletion.
		 */
		public Node delete(Key key) {
		    if (this.find(key) == null) return

		    int compare = this.getKey().compareTo(key);
		    if (compare < 0) {
		    	mLeft = mLeft.delete(key);
			}
		    if (compare > 0) return this.mRight.delete(key);

		    // Deleting node
		    if (this.mLeft == null && this.mRight == null) {
		    	return this;
			} else if (this.mLeft ==null) {
		    	// has L child
			} else if (this.mRight == null) {
		    	// has R child
			} else {
		    	// has L, R child
			}
	}

		private Node mRoot;
		public BinaryTree() {
			mRoot = null;
		}

		public void insert(Key key, E value) {
			if (mRoot == null) {
				mRoot = new Node(key, value);
			} else {
				mRoot.insert(key, value);
			}
		}

		public void delete(Key key) {
			if (mRoot == null)
				return;
			mRoot = mRoot.delete(key);
		}

		public E find(Key key) {
			if (mRoot == null)
				return null;
			return mRoot.find(key);
		}

		public void preorder() {
			System.out.print("preorder : ");
			if (mRoot == null) {
				System.out.println("None");
				return;
			}
			System.out.println(mRoot.preorder());
		}

		public void inorder() {
			System.out.print("inorder : ");
			if (mRoot == null) {
				System.out.println("None");
				return;
			}
			System.out.println(mRoot.inorder());

		}

		public void postorder() {
			System.out.print("postorder : ");
			if (mRoot == null) {
				System.out.println("None");
				return;
			}
			System.out.println(mRoot.postorder());
		}

		public int height() {
			if (mRoot == null)
				return 0;
			return mRoot.height();
		}

		public void iscomplete()
		{	boolean flag = mRoot.iscomplete(mRoot);
			if (flag)
				System.out.println("The tree is complete binary tree.");
			else
				System.out.println("The tree is not complete.");
		}

	}
}