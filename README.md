 EC Site Spring

● システム概要

Spring BootとPostgreSQLを用いて開発したECサイトです。

ユーザー登録、ログイン、商品購入、購入履歴確認、管理者による商品管理機能を実装しています。

● 使用技術

・ Java 21
・ Spring Boot
・ Spring Data JPA
・ Thymeleaf
・ PostgreSQL
・ HTML
・ CSS
・ Git / GitHub

● 主な機能

● ユーザー機能

・ ユーザー登録
・ ログイン / ログアウト
・ 商品一覧表示
・ 商品詳細表示
・ カート機能
・ 商品購入
・ 購入履歴確認
・ 購入履歴詳細表示
・ マイページ表示

● 管理者機能

・ 管理者ログイン
・ 商品一覧表示
・ 商品追加
・ 商品編集
・ 商品販売停止
・ 商品販売再開

● 画面一覧

● ユーザー画面

・ 商品一覧画面
・ ログイン画面
・ 会員登録画面
・ カート画面
・ 購入確認画面
・ 購入完了画面
・ 購入履歴画面
・ 購入履歴詳細画面
・ マイページ画面

● 管理者画面

・ 管理者ログイン画面
・ 管理画面
・ 商品一覧画面
・ 商品追加画面
・ 商品編集画面

● データベース構成

● users

|列名|説明|
|-----|-----|
|user_id|ユーザーID|
|login_id|ログインID|
|password|パスワード|
|user_name|ユーザー名|

● products

|列名|説明|
|-----|-----|
|product_id|商品ID|
|product_name|商品名|
|price|価格|
|stock|在庫数|
|active|販売状態|
|image_data|商品画像|

● orders

|列名|説明|
|-----|-----|
|order_id|注文ID|
|user_id|ユーザーID|
|order_date|注文日時|

● order_details

|列名|説明|
|-----|-----|
|detail_id|明細ID|
|order_id|注文ID|
|product_id|商品ID|
|quantity|数量|
|price|購入時価格|

● セットアップ手順

● データベース作成

sql/create_tables.sql を実行してください。

● application.properties設定

PostgreSQL接続情報を設定してください。

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ec_site_db
spring.datasource.username=postgres
spring.datasource.password=********

●開発期間

2026年6月

●制作目的

Spring Bootを用いたWebアプリケーション開発の学習を目的として制作しました。
ユーザー機能と管理者機能を備えたECサイトを構築し、データベース設計、CRUD処理、セッション管理について学習しました。