# spring-guides
Spring公式のガイドを使った練習用リポジトリ

## REST API の作成 実施
2021/2/23 (火)

### 対象ページ：
https://spring.pleiades.io/guides/gs/rest-service/

### 所感：
Springのプロジェクト設定でWebを指定するだけでJacksonが入ることに驚いた。便利。

### JUnit作成：
2021/3/17 (水)
簡単なJUnitでも試そうとしてまさかのエラーが発生。  
基礎的な使い方を調べても何もおかしな所がないが...  
pom.xmlへJUnitを定義していないことに気づいた。  
ただ、他のプラグインに既存でバンドルされている可能性もあるから、  
入れる時は確認するべき？  
例：spring-boot-starter-testにmockito-junit-jupiterが入っているが、自前でも定義する。  
   最新のバージョンを入れたいときには有効か。  

もう少し理解が深まったらDIやPowerMockやMockitoを使用したテストコードを作っていく。

## @Scheduled アノテーションで定期実行 実施
2021/3/25 (木)

### 対象ページ：
https://spring.pleiades.io/guides/gs/scheduling-tasks/

### 所感：
例えばフォルダ監視の処理を作って、自動バックアップ処理とか作れそう。  
毎時や週次など時間指定での自動実行もできるので、  
処理の自動化に一役買いそう。  

## RestTemplate で REST API の利用
2021/4/6 (火)  

### 対象ページ
https://spring.pleiades.io/guides/gs/consuming-rest/  

### 所感
RestTemplate#getForObjectの第一引数に指定したURLから取得した値を  
第二引数のクラスのキーに合致したものを詰めて、  
ログに値を出力している。  
返される値が決まっている外部のWEB APIを解析するのに使えそう。  
図書館蔵書検索や日本政府提供の統計情報を検索できそう。  
参考URL：  
https://calil.jp/doc/api.html  
https://dstn.appresso.com/hc/ja/articles/220345967  

## Spring JDBC JdbcTemplate で SQL 発行  
2021/4/6 (火)  

### 対象ページ
https://spring.pleiades.io/guides/gs/relational-data-access/  

### 所感
SQL文へ値をバインドする時にJdbcTemplateを使用することでSQLインジェクション対策になるそうだ。  
Java11だと一部のqueryメソッドが非推奨だったため、RowMapperクラスを自作し、使用した。  
SQL文をあらかじめ用意してあれば書くのは簡単だけど、  
複数記述ミスが合った場合、ミスの発見に手間がかかりそう。  
エンティティに値を入れてエンティティベースで更新出来たほうがミスは減る気がする。  
SQLをXMLに書く等であれば分業できるからいいが、Javaソースに直接書くなら利点はあまり無い気がする。  
