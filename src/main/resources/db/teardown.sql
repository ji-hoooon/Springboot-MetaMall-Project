SET FOREIGN_KEY_CHECKS=0;
-- SET REFERENTIAL_INTEGRITY FALSE;
-- drop table transaction_tb;
-- drop table account_tb;
-- drop table user_tb;
-- truncate table transaction_tb;
truncate table product_tb;
truncate table order_product_tb;
truncate table order_sheet_tb;
truncate table user_tb;
-- 테이블 안의 모든 내용을 지운다.
-- SET REFERENTIAL_INTEGRITY TRUE;
SET FOREIGN_KEY_CHECKS=1;