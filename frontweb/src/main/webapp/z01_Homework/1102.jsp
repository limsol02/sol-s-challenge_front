<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
[1단계:개념] 1. iframe의 주요속성을 기본 예제를 통해서 기술하세요.

==> iframe 안에 src(포함할 페이지) width(넓이) height(높이) 를 같이넣어 
제가 원하는 크기의 틀을 하나 만들어 src의 내용을 표시하거나 targer/name을 이용하여 만든 틀에 표시하게 할 수 있습니다.
<iframe scr="ex2-01.html"></iframe> // (따로 넓이나 높이를 표기하지않으면 300과 150으로 기본 설정 )
로 틀을 만들 수 있습니다.


[1단계:확인] 2. z01_top.html(최상위), z02_left.html(왼쪽메뉴), z03_main.html(오른쪽메인메뉴) 파일을 만들고,
              z01_top.html에 계층형 프레임구조를 만들어, 왼쪽메뉴 리스트를 클릭시, 오른쪽 메인메뉴들이 출력되게 하세요
              
[1단계:확인] 3. a href의 target의 의미를 예제를 통하여 기술하세요.

==>a href에 출력을 원하는 외/내부 페이지를 입력하고 target 원하는 위치나 다른 최상위 html의 iframe의 name을 
입력하면 그 최상위 페이지 name 에 맞는 곳으로 href의 내용이 출력이 됩니다.
<a href ="내부페이지 주소" target="_self">내부페이지이동</a> 라고 설정을 해놓고 내부페이지이동이라는 
글자의 링크를 클릭하게 되면 target의 _self로 새로운 페이지에서 창을 띄우게 됩니다.(디폴트값이 _self)


[1단계:개념] 4. 요청값전달방식(2단계)의 페이지?key=val의 의미를 기술하고, 이것을 처리하는 패턴 3가지를 기술하세요.

==> form 형식 안에서 submit으로 전달하게 되면 name(key)으로 설정해두었던 값이 실제 val(value)값으로 서버에 전송이 됩니다. 
첫번째는 form 하위에 action을 정보를 받아들일 곳으로 설정을 해놓고 <input type="text">등으로 입력하여 value값을
전송하는 방이 있고, 두번쨰는 a herf ="정보를 받아들일 jsp"?key=value" 로 처리될 수도 있고
location.herf="정보를 받아들일 jsp"?key=value"로 처리될 수도 있습니다.

[1단계:확인] 2. z01_top.html(최상위), z02_left.html(왼쪽메뉴), z03_main.html(오른쪽메인메뉴) 파일을 만들고,
              z01_top.html에 계층형 프레임구조를 만들어, 왼쪽메뉴 리스트를 클릭시, 오른쪽 메인메뉴들이 출력되게 하세요
 <왼쪽>

<body>
    <h4>왼쪽 프레임</h4>
    <ol>
        <ul><a href="z03_main.html" target="frame02"> 코레일 연결</a></ul>
        <ul><a href="z03_main02.html" target="frame02">야놀자 연결</a></ul>
       
    </ol>
    
</body>

<오른쪽1>
<body>
    <h4>오른쪽 프레임</h4>
    <iframe src = "https://www.letskorail.com/" name="upper" width="100%" height="200"></iframe>
              
<오른쪽2>
<body>
    <iframe src = "https://www.yanolja.com/" name="lower" width="100%" height="200"></iframe>
</body>

<최상위>
<body>
    <h2>최상위 페이지</h2>
    <iframe src="z02_left.html" name="frame01" width="30%" height="200"></iframe>
    <iframe src="z03_main.html" name="frame02" width="65%" height="200"></iframe>
    
</body>
<script>
    var iframe02Ob = document.querySelector("[name=frame02]")
    var iframeDoc=iframe02Ob.contentDocument
   
</script>

[1단계:확인] 5. 물건명:[   ], 가격:[   ], 갯수:[   ] [구매] 폼 페이지(z04_buyForm.html) 만들어, 구매를 클릭시,
              z05_buyProductInfo.jsp에서 입력한 구매 정보가 출력되게 하세요.
              
 
<z04_buyForm.html>
<body>
	<form action="z05_buyProductInfo.jsp" name="product" method="get">
		물건명 : <input type="text" name="pname" value="">
		가격 : <input type="text" name="pirce" value="">
		갯수 : <input type="text" name="cnt" value="">
		<input type="submit">
	</form>

</body>
<z05_buyProductInfo.jsp>
<body>
	<h2>서버 도달 데이터</h2>
	<h2>물건명 :${param.pname}</h2>
	<h2>가격 :${param.price} </h2>
	<h2>갯수 :${param.cnt} </h2>

</body>



 --%>
</body>
</html>