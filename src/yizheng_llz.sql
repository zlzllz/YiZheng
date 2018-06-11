--------------------------------------------------------
--  文件已创建 - 星期一-五月-15-2017   
--  创建全部表
-----------------------------------------------------------------
--1.部门表
CREATE TABLE zdept
  (
    id     NUMBER(4) PRIMARY KEY NOT NULL,
    dname  VARCHAR(100),
    salary NUMBER(6,1)
  );
--2.职工表--一个外键依赖于部门表
CREATE TABLE zemp
  (
    id    NUMBER(4) PRIMARY KEY NOT NULL,
    d_id  NUMBER(4),
    ename VARCHAR(100),
    sex   VARCHAR(2),
    age   NUMBER(3),
    tel   VARCHAR(20),
    jobb  VARCHAR(50),
    timee DATE,
    grade NUMBER(1) DEFAULT 0
  );
--3.供货商表（rname表示联系人的姓名）
CREATE TABLE zsupplier
  (
    id      NUMBER(4) PRIMARY KEY NOT NULL,
    sname   VARCHAR(100),
    tel     VARCHAR(20),
    rname   VARCHAR(100),
    email   VARCHAR(50),
    address VARCHAR(100)
  );
--4.客户表（rname表示联系人的姓名）
CREATE TABLE zclient
  (
    id      NUMBER(4) PRIMARY KEY NOT NULL,
    cname   VARCHAR(100),
    tel     VARCHAR(20),
    rname   VARCHAR(100),
    email   VARCHAR(50),
    address VARCHAR(100)
  );
--5.商品表(pname表示成品名称)--进货后加工的成品表
CREATE TABLE zproduct
  (
    id    NUMBER(4) PRIMARY KEY NOT NULL,
    pname VARCHAR(100),
    typee VARCHAR(100),
    unit  VARCHAR(20),
    img   VARCHAR(500),
    price NUMBER(6,1)
  );
--6.进货单(jname表示进货的名字)--两个外键，依赖于员工表，供货商表
CREATE TABLE zpurchase
  (
    id    NUMBER(4) PRIMARY KEY NOT NULL,
    s_id  NUMBER(4),
    e_id  NUMBER(4),
    jname VARCHAR(100),
    num   NUMBER(4),
    price NUMBER(6,1),
    timee DATE
  );
--7.订单表--有3个外键，依赖于供货商表，商品表，职工表
CREATE TABLE zorder
  (
    id     NUMBER(4) PRIMARY KEY NOT NULL,
    c_id   NUMBER(4),
    p_id   NUMBER(4),
    e_id   NUMBER(4),
    num    NUMBER(4),
    status NUMBER(1) DEFAULT 0,
    timee  DATE,
    ispay  NUMBER(1) DEFAULT 0,
    pay    NUMBER(6,1)
  );
--8.用户表
CREATE TABLE zusers
  (
    id   NUMBER(4) PRIMARY KEY NOT NULL,
    name VARCHAR(100),
    pass VARCHAR(500)
  );
--------------------------------------------------------------
--  建立外键约束
---------------------------------------------------------------
--1.职工表
ALTER TABLE zemp ADD CONSTRAINT zemp_d_id FOREIGN KEY (d_id) REFERENCES zdept(id) ON
DELETE CASCADE;
--2.进货单
ALTER TABLE zpurchase ADD CONSTRAINT zpur_s_id FOREIGN KEY (s_id) REFERENCES zsupplier(id) ON
DELETE CASCADE;
ALTER TABLE zpurchase ADD CONSTRAINT zpur_e_id FOREIGN KEY (e_id) REFERENCES zemp(id) ON
DELETE CASCADE;
--3.订单表
ALTER TABLE zorder ADD CONSTRAINT zord_c_id FOREIGN KEY (c_id) REFERENCES zclient(id) ON
DELETE CASCADE;
ALTER TABLE zorder ADD CONSTRAINT zord_p_id FOREIGN KEY (p_id) REFERENCES zproduct(id) ON
DELETE CASCADE;
ALTER TABLE zorder ADD CONSTRAINT zord_e_id FOREIGN KEY (e_id) REFERENCES zemp(id) ON
DELETE CASCADE;
------------------------------------------------------------
--  创建每张表的序列
-----------------------------------------------------------
--1.部门表
CREATE sequence zde_id start with 1 increment BY 1 minvalue 1 nomaxvalue nocycle nocache;
  --2.职工表
CREATE sequence zemp_id start with 1 increment BY 1 minvalue 1 nomaxvalue nocycle nocache;
  --3.供货商表
CREATE sequence zsup_id start with 1 increment BY 1 minvalue 1 nomaxvalue nocycle nocache;
  --4.客户表
CREATE sequence zcli_id start with 1 increment BY 1 minvalue 1 nomaxvalue nocycle nocache;
  --5.商品表
CREATE sequence zpro_id start with 1 increment BY 1 minvalue 1 nomaxvalue nocycle nocache;
  --6.进货单
CREATE sequence zpur_id start with 1 increment BY 1 minvalue 1 nomaxvalue nocycle nocache;
  --7.订单表
CREATE sequence zord_id start with 1 increment BY 1 minvalue 1 nomaxvalue nocycle nocache;
  --8.用户表
CREATE sequence zus_id start with 1 increment BY 1 minvalue 1 nomaxvalue nocycle nocache;
-------------------------------------------------------
--  创建触发器
--------------------------------------------------------
--1.部门表
create or replace trigger zdept_insert
  before insert on zdept
  for each row
begin
  select zde_id.nextval into :new.id from sys.dual;
end;
--2.职工表
create or replace trigger zemp_insert
  before insert on zemp
  for each row
begin
  select zemp_id.nextval into :new.id from sys.dual;
end;
--更新数据时自动更新时间
create or replace trigger zemp_insert_time
  before insert or update of timee on zemp
  for each row
begin
  :new.timee := sysdate;
end;
--3.供货商表
create or replace trigger zsup_insert
before insert on zsupplier
for each row
begin
select zsup_id.nextval into :new.id from sys.dual;
end;
--4.客户表
create or replace trigger zcli_insert
  before insert on zclient
  for each row
begin
  select zcli_id.nextval into :new.id from sys.dual;
end;
--5.商品表
create or replace trigger zpro_insert
before insert on zproduct
for each row
begin
select zpro_id.nextval into :new.id from sys.dual;
end;
--6.进货单
create or replace trigger zpur_insert
  before insert on zpurchase
  for each row
begin
  select zpur_id.nextval into :new.id from sys.dual;
end;
--更新数据时自动更新时间
create or replace trigger zpur_insert_time
  before insert or update of timee on zpurchase
  for each row
begin
  :new.timee := sysdate;
end;
--7.订单表
create or replace trigger zord_insert
  before insert on zorder
  for each row
begin
  select zord_id.nextval into :new.id from sys.dual;
end;
--更新数据时自动更新时间
create or replace trigger zord_insert_time
  before insert or update of timee on zorder
  for each row
begin
  :new.timee := sysdate;
end;
--8.用户表
create or replace trigger zusers_insert
  before insert on zusers
  for each row
begin
  select zus_id.nextval into :new.id from sys.dual;
end;
---------------------------------------------------
--  添加数据
----------------------------------------------------
Insert into SCOTT.ZDEPT (ID,DNAME,SALARY) values (1,'前台',3000);
Insert into SCOTT.ZDEPT (ID,DNAME,SALARY) values (2,'生产',123);
Insert into SCOTT.ZDEPT (ID,DNAME,SALARY) values (3,'销售',123);
commit;

Insert into SCOTT.ZEMP (ID,D_ID,ENAME,SEX,AGE,TEL,JOBB,TIMEE) values (1,1,'李四','男',20,'13187654321','开发',to_date('04-5月 -17','DD-MON-RR'));
Insert into SCOTT.ZEMP (ID,D_ID,ENAME,SEX,AGE,TEL,JOBB,TIMEE) values (2,2,'职工1','女',18,'18452125654','设计',to_date('08-5月 -17','DD-MON-RR'));
Insert into SCOTT.ZEMP (ID,D_ID,ENAME,SEX,AGE,TEL,JOBB,TIMEE) values (3,1,'职工2','男',18,'13025648512','管理',to_date('08-5月 -17','DD-MON-RR'));
Insert into SCOTT.ZEMP (ID,D_ID,ENAME,SEX,AGE,TEL,JOBB,TIMEE) values (4,2,'职工3','女',18,'15547854126','测试',to_date('08-5月 -17','DD-MON-RR'));
Insert into SCOTT.ZEMP (ID,D_ID,ENAME,SEX,AGE,TEL,JOBB,TIMEE) values (5,3,'llz','女',18,'15489652365','开发',to_date('05-5月 -17','DD-MON-RR'));
commit;

Insert into SCOTT.ZSUPPLIER (ID,SNAME,TEL,RNAME,EMAIL,ADDRESS) values (1,'供货商1','13000000000','供货者1','123455678@163.com','北京市昌平区');
Insert into SCOTT.ZSUPPLIER (ID,SNAME,TEL,RNAME,EMAIL,ADDRESS) values (2,'供货商2','13011111111','供货者2','123455678@163.com','山西省太原市');
Insert into SCOTT.ZSUPPLIER (ID,SNAME,TEL,RNAME,EMAIL,ADDRESS) values (3,'供货商3','12312345678','供货者3','903382522@qq.com','西藏');
commit;

Insert into SCOTT.ZUSERS (ID,NAME,PASS) values (1,'李四','698d51a19d8a121ce581499d7b701668');
Insert into SCOTT.ZUSERS (ID,NAME,PASS) values (2,'llz','e10adc3949ba59abbe56e057f20f883e');
commit;

Insert into SCOTT.ZCLIENT (ID,CNAME,TEL,RNAME,EMAIL,ADDRESS) values (1,'客户1','13500000000','客A','123455678@163.com','北京市昌平区');
Insert into SCOTT.ZCLIENT (ID,CNAME,TEL,RNAME,EMAIL,ADDRESS) values (2,'客户2','13522222222','客B','123455678@163.com','北京市丰台区');
Insert into SCOTT.ZCLIENT (ID,CNAME,TEL,RNAME,EMAIL,ADDRESS) values (3,'客户3','12312345678','艾玛','903382522@qq.com','西藏');
Insert into SCOTT.ZCLIENT (ID,CNAME,TEL,RNAME,EMAIL,ADDRESS) values (4,'客户4','13522222222','客C','123455678@163.com','山西省吕梁市');
Insert into SCOTT.ZCLIENT (ID,CNAME,TEL,RNAME,EMAIL,ADDRESS) values (5,'客户5','13522222222','客D','123455678@163.com','上海市浦东区');
commit;

Insert into SCOTT.ZPRODUCT (ID,PNAME,TYPEE,UNIT,IMG,PRICE) values (1,'展板1','玻璃','平方米','Tulips.jpg',200);
Insert into SCOTT.ZPRODUCT (ID,PNAME,TYPEE,UNIT,IMG,PRICE) values (2,'展板2','塑料','平方米','Desert.jpg',100);
Insert into SCOTT.ZPRODUCT (ID,PNAME,TYPEE,UNIT,IMG,PRICE) values (3,'写真1','type2','m2','Lighthouse.jpg',100);
Insert into SCOTT.ZPRODUCT (ID,PNAME,TYPEE,UNIT,IMG,PRICE) values (4,'写真2','type1','m2','Tulips.jpg',8);
Insert into SCOTT.ZPRODUCT (ID,PNAME,TYPEE,UNIT,IMG,PRICE) values (5,'KT板1','type2','m2','Desert.jpg',100);
Insert into SCOTT.ZPRODUCT (ID,PNAME,TYPEE,UNIT,IMG,PRICE) values (6,'喷布1','type1','m2','Tulips.jpg',22.2);
Insert into SCOTT.ZPRODUCT (ID,PNAME,TYPEE,UNIT,IMG,PRICE) values (7,'KT板2','type1','m2','Lighthouse.jpg',11);
Insert into SCOTT.ZPRODUCT (ID,PNAME,TYPEE,UNIT,IMG,PRICE) values (8,'喷布2','type1','m2','person.jpg',22.2);
commit;

Insert into SCOTT.ZORDER (ID,C_ID,P_ID,E_ID,NUM,STATUS,TIMEE,ISPAY,PAY) values (1,1,1,1,2,1,to_date('04-5月 -17','DD-MON-RR'),1,222);
Insert into SCOTT.ZORDER (ID,C_ID,P_ID,E_ID,NUM,STATUS,TIMEE,ISPAY,PAY) values (2,1,2,1,111,1,to_date('04-5月 -17','DD-MON-RR'),1,9);
Insert into SCOTT.ZORDER (ID,C_ID,P_ID,E_ID,NUM,STATUS,TIMEE,ISPAY,PAY) values (3,2,3,2,1,0,to_date('07-5月 -17','DD-MON-RR'),0,1);
Insert into SCOTT.ZORDER (ID,C_ID,P_ID,E_ID,NUM,STATUS,TIMEE,ISPAY,PAY) values (4,3,4,2,9,0,to_date('05-5月 -17','DD-MON-RR'),0,9);
commit;

Insert into SCOTT.ZPURCHASE (ID,S_ID,E_ID,JNAME,NUM,PRICE,TIMEE) values (1,2,1,'原材料1',10,10,to_date('04-5月 -17','DD-MON-RR'));
Insert into SCOTT.ZPURCHASE (ID,S_ID,E_ID,JNAME,NUM,PRICE,TIMEE) values (2,1,1,'亮膜',111,22,to_date('05-5月 -17','DD-MON-RR'));
Insert into SCOTT.ZPURCHASE (ID,S_ID,E_ID,JNAME,NUM,PRICE,TIMEE) values (3,1,1,'亚膜',111,22,to_date('09-5月 -17','DD-MON-RR'));
Insert into SCOTT.ZPURCHASE (ID,S_ID,E_ID,JNAME,NUM,PRICE,TIMEE) values (4,2,2,'原材料2',10,10,to_date('16-5月 -17','DD-MON-RR'));
commit;