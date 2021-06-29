/**
 * 
 */
//자바스크립트가 먹습니다.
//alert("Hi");
/* for (var i = 0; i < 5; i++) {
	alert(i);
} */
/* 자바랑 같은 여러 줄 주석
 * 
 */
 
 //타입 변수명 = 값;
 var number = 100;//number
 number = "A";//string
 number = true;//boolean
 number = 1.0001;//number
 number = null;//object
 
 //alert(typeof number);
 
 number = 10;
 var str = "10";
 /*
 alert(number == str);//참 = 데이터형말고 값만 비교
 alert(number != str);//거짓
 
 alert(number === str);//거짓 데이터형까지 비교하기
 alert(number !== str);//참
 */
/*
switch(number){
	case 1:
		alert();
		break;
	case 10:
		alert("10입니다.");
		break;
	default:
		alert();
}
 
while(number < 15){
	alert("15보다 작습니다.");
	number++;
}


do{
	
}while();
 */

		//var input = prompt("OK를 입력해주세요.");
		//document.write(input + "스크립트로 찍습니다.");
		
		//var input2 = confirm("정말 맞나요?");//예 참 /취소 거짓
		//alert(input2);
		/*
		var color = ['red', 'green','blue', 'gray'];
		 for (var i = 0; i < color.length; i++) {
			alert(color[i]);
		} 
		for(var temp in color){
			alert(color[temp]);//index
		}
		
		var numbers = new Array(10, 20, 30, "A", true, 3.14);
		alert(numbers);
		
		
		var obj = {
				"name" : "홍길동",
				"age" : 150,
				"addr" : "한양"
		};
	
		alert(obj.name);
		alert(obj.age);
		alert(obj.addr);
		*/
		var map = new Map();
		map.set("temp1" , "temp100");
		map.set("temp2" , "temp200");
		map.set("temp3" , "temp400");
		//alert(map.get("temp1"));
		//alert(map.get("temp2"));
		//키 뽑기 다시하기
		
		let set = new Set();
		set.add("hong");
		set.add("kim");
		set.add("lee");
		set.add("park");
		alert(set);
		
		