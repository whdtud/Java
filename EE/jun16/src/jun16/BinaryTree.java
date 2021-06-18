package jun16;

import java.util.TreeSet;

/* 2진 트리
 * 이진트리는 여러개의 노드(node)가 트리형태로 연결된 구조
 * 루트(root)라고 불리는 하나의 노드에서 시작해 각 노드에
 * 최대 2개의 노드를 연결할 수 있는 구조
 * 
 * 연결된 두 노드를 부모-자식 관계에 있다고 하며
 * 이에 있는 노드를 부모노드, 아래 노드를 자식노드라고 한다.
 * 하나의 부모노드는 최대 두개의 자식 노드와 연결될 수 있다.
 * 
 * 첫 번째 저장하는 값은 루트 노드가 되고 두번째 값은
 * 루트 노드에서 값의 크기를 비교하면서 트리를 따라 내려간다.
 * (숫자가 아닌 문자를 저장할 경우 = 문자의 유니코드값을 비교)
 * 
 * 작은 값은 왼쪽에, 큰 값은 오른쪽에 저장
 * 이렇게 구성하면 왼쪽 마지막 노드가 제일 작은 값
 * 제일 큰 값이 오른쪽 끝에 위치합니다.
 * 
 * TreeSet
 * 이진트리를 기반으로 한 set
 * 하나의 노드는 노드 값인 value와 왼쪽과 오른쪽 자식 노드를
 * 참고하기 위한 두개의 변수로 구성되어 있음.
 * 
 * TreeSet에 값을 저장하면 자동으로 정렬됨
 * 부모 값과 비교해서 낮은 것은 왼쪽에, 높은 것은 오른쪽에 저장
 * 
 * first() 가장 작은 값 리턴
 * last() 가장 큰 값 리턴
 * lower(v) v보다 작은 값 리턴
 * higher(v) v보다 바로 위 객체 리턴
 * floor(v) v와 동등한 객체가 있으면 리턴, 없으면 바로 아래 값 리턴
 * ceilling(v) v와 동등한 객체가 있으면 리턴, 없으면 상위 객체 리턴
 * pollFirst() 제일 낮은 객체를 꺼내오고 컬랙션에서 삭제
 * pollLast() 제일 높은 객체를 꺼내오고 컬랙션에서 삭제
 * 
 */

public class BinaryTree {
	
	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(50);
		ts.add(25);
		ts.add(70);
		
		System.out.println(ts.first());
		System.out.println(ts.last());
		System.out.println(ts.higher(20));
	}
}
