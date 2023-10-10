# ezenTeamProject
활용 언어: 
<img src="https://img.shields.io/badge/spring-6DB33F?style=flat&logo=spring&logoColor=white"/>
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=flat&logo=javascript-&logoColor=white"/>
<img src="https://img.shields.io/badge/css3-1572B6?style=flat&logo=css&logoColor=white"/>
<img src="https://img.shields.io/badge/html5-E34F26?style=flat&logo=html5&logoColor=white"/>
<br>
툴: 
<img src="https://img.shields.io/badge/eclipseide-2C2255?style=flat&logo=eclipseide&logoColor=white"/>
<img src="https://img.shields.io/badge/visualstudiocode-007ACC?style=flat&logo=visualstudiocode&logoColor=white"/>
<img src="https://img.shields.io/badge/intellijidea-000000?style=flat&logo=intellijidea&logoColor=white"/>
추가 의존성: 
Mysql 코드:<br>
<pre>
  # 순서대로 실행 하시오
<code>
CREATE database TeamProject;
use TeamProject;
CREATE TABLE USERINFO (
					inherenceID int primary KEY auto_increment, #고유번호 생성 기본키
                    userID varchar(255) unique,
                    userEmail varchar(255) Not NULL,
                    userPassword varchar(255) NOT NULL,
                    userName varchar(255) NOT NUll,
                    userPhone varchar(255) NOT NULL,
                    userBirth varchar(255), #생년월일
                    userPost varchar(255), #우편번호
                    userAddr varchar(255), #주소
                    addr_detail varchar(255) #상세주소
                    );
                    
create table ITEM (
				itemID int primary key auto_increment, #아이템 고유 번호 기본키
                itemName varchar(255) unique,
                itemAmount int NOT NULL,
                itemType varchar(255), # 타입(여성, 남성)
                itemCount int, #재고수량
                itemImg varchar(255), #아이템 이미지 파일 이름
                itemInfoDetail varchar(255) #아이템 설명
				);
                
create table ITEMBASKET (
						basketID int primary key auto_increment, #장바구니 고유 번호
                        inherenceID INT, #참조하는 유저 번호
                        itemID INT, #참조하는 아이템 번호
						FOREIGN KEY (inherenceID) REFERENCES USERINFO(inherenceID),
						FOREIGN KEY (itemID) REFERENCES ITEM(itemID)
						);

CREATE TABLE BOARD (
	boardID int primary KEY auto_increment, #평가 번호
    inherenceID int, #작성자 고유 아이디
    userName varchar(255), #작성자 이름
    boardName varchar(255), #게시판 제목
    boardTime varchar(255), #작성 시간
    boardDivide varchar(255), #게시판 구분
    boardContents varchar(2048), #게시판 내용
    FOREIGN KEY (inherenceID) REFERENCES USERINFO(inherenceID) #유저 고유번호 참조
);
insert into ITEM VALUES (null, '여성의류1', 300000, '여성', 10, 'woman_251_403_(1).jpg', '면소재 의류');
insert into ITEM VALUES (null, '여성의류2', 100000, '여성', 5, 'woman_251_403_(2).jpg', '면');
insert into ITEM VALUES (null, '여성의류3', 150000, '여성', 5, 'woman_251_403_(3).jpg', '면');
insert into ITEM VALUES (null, '여성의류4', 130000, '여성', 5, 'woman_251_403_(4).jpg', '면');
insert into ITEM VALUES (null, '여성의류5', 70000, '여성', 5, 'woman_251_403_(5).jpg', '면');
insert into ITEM VALUES (null, '여성의류6', 230000, '여성', 5, 'woman_251_403_(6).jpg', '면');
insert into ITEM VALUES (null, '여성의류7', 180000, '여성', 5, 'woman_251_403_(7).jpg', '면');
insert into ITEM VALUES (null, '여성의류8', 190000, '여성', 5, 'woman_251_403_(8).jpg', '면');
insert into ITEM VALUES (null, '여성의류9', 140000, '여성', 5, 'woman_251_403_(9).jpg', '면');
insert into ITEM VALUES (null, '여성의류10', 160000, '여성', 5, 'woman_251_403_(10).jpg', '면');

select * from USERINFO;
select * from ITEM where itemName Like '%여성의류1%';
select * from itembasket;
select * from board;

rollback;
commit;
</code>
</pre>
