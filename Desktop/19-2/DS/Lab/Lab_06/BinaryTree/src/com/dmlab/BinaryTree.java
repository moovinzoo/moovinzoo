package com.dmlab;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
			int compare = this.getKey().compareTo(key);
			if (compare == 0) {
				// same key
				this.mValue = value;
			}
			else if(compare < 0) {
				if(this.mLeft == null) {
					this.mLeft = new Node(key, value);
				} else {
					this.mLeft.insert(key, value);
				}
			} else { // compare > 0
				//right
				if(this.mRight == null) {
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
			}

			else if(compare < 0) {
				if(this.mLeft == null) {
					return null;
				} else {
					return this.mLeft.find(key);
				}
			} else { // compare > 0
				//right
				if(this.mRight == null) {
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

			if(this.mLeft != null) sb.append(this.mLeft.preorder());

			if(this.mRight != null) sb.append(this.mRight.preorder());

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
			if(this.mLeft != null) sb.append(this.mLeft.preorder());
			sb.append(this.toString());
			if(this.mRight != null) sb.append(this.mRight.preorder());

			return sb.toString();

		}

		public Node findMin() {
			if (mLeft == null)
				return this;
			else
				return mLeft.findMin();
		}

		public Node findMax() {
			if (mRight == null)
				return this;
			else
				return mRight.findMax();
		}

		/**
		 * Delete a node,the key of which match with the key given as param, from this subtree.
		 * You may need to define new method to find minimum of the subtree.
		 *
		 * @return the node of which parent needs to point after the deletion.
		 */
		public Node delete(Key key) {
			// TODO: Fill this function
//            if (this.find(key) == null)
//            	return null;
//
//            if (this.getKey().compareTo(key) == 0) {
//            	if (mLeft == null && mRight == null) {
//
//				} else if (mLeft == null && mRight != null) {
//            		thi;
//				} else if (mLeft != null && mRight == null) {
//
//				} else { // has two child node
//
//				}
//
//			} else if (this.getKey().compareTo(key) < 0) {
//            	this.mLeft.delete(key);
//			} else if (this.getKey().compareTo(key) > 0) {
//            	this.mRight.delete(key);
//			}

			if (this.find(key) == null) return null;

			if (this.mLeft.find(key) != null) {
				if (this.mLeft.getKey().compareTo(key) == 0) {
					if (this.mLeft.mLeft == null && this.mLeft.mRight == null) {
						this.mLeft = null;
						return null;
					} else if (this.mLeft.mLeft != null && this.mLeft.mRight == null) {
						this.mLeft = this.mLeft.mLeft;
						return this.mLeft;
					} else {
						this.mLeft = this.mLeft.mRight;
						return this.mLeft;
					}
				} else {
					return this.mLeft.delete(key);
				}
			} else if (this.mRight.find(key) != null) {
				if (this.mRight.getKey().compareTo(key) == 0) {
					if (this.mRight.mLeft == null && this.mRight.mRight == null) {
						this.mRight = null;
						return null;
					} else if (this.mRight.mLeft != null && this.mRight.mRight == null) {
						this.mRight = this.mRight.mLeft;
						return this.mRight;
					} else {
						this.mRight = this.mRight.mRight;
						return this.mRight;
					}
				} else {
					return this.mRight.delete(key);
				}
			} else {
				// TODO : root would be deleted
				return null; // I don't know
			}
		}

		/**
		 * Flatten binary search tree into binary tree
		 *
		 */
		public void flattenBinaryTree(Node root) {
			// TODO: Fill this function

		}

		/**
		 * Find the lowest common ancestor
		 * If k1 or k2 are not in the tree, return the root
		 * @return
		 */
		public Node lowestCommonAncestor(Node root, Key k1, Key k2) {
			// TODO: Fill this function
			return null;
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

	public void flattenBinaryTree() {
		System.out.println("Flatten binary seatch tree");
		if (mRoot == null) ;
		else
			mRoot.flattenBinaryTree(mRoot);
	}

	public void lowestCommonAncestor(Key k1, Key k2) {
		if (mRoot == null)
			System.out.println("The tree is empty");
		else if (k1 == null || k2 == null) {
			System.out.println("Error, the key is null");
		} else if (mRoot.find(k1) != null && mRoot.find(k2) != null) {
			Node n = mRoot.lowestCommonAncestor(mRoot, k1, k2);
			System.out.println("LCA of " + k1 + " and " + k2 + " : [" + n.getKey() + ":" + n.getValue() + "]");
		} else {
			System.out.println("The key doesnt exist");
		}

	}
}
