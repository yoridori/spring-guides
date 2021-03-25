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