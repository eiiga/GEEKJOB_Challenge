<%-- 
    Document   : framework
    Created on : 2017/09/15, 13:29:47
    Author     : ei-tk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>フレームワーク<br>
            (1)：Struts［Webアプリケーションフレームワーク］<br>
                特徴：独自のカスタムタグの利用や、
                Actionクラスとstruts-config.xmlでの画面遷移の管理、
                バリデータ（入力チェック）機能の提供などが挙げられる。<br><br>
            (2)：JSF(Java Server Faces)［Webアプリケーションフレームワーク］<br>
                特徴：Strutsと同じくMVCモデルを採用したフレームワークだが、
                StrutsのようにURLによってアクション（プログラム）が決まる
                「アクションベースフレームワーク」ではなく、表示する画面に対応する
                サーバーサイドのクラス（バッキングBean）によって処理が行われる
                「コンポーネントベースフレームワーク」という違いがある。
                また、MVCモデルのView（表示）にはJSPで実装されるケースが多いが、
                JSFは「XHTML」というXML形式のHTMLで実装される。
                JSPはサーブレットの処理なしでは正しく表示されないが、
                XHTMLの場合はブラウザでそのまま表示されるので、
                デザインの確認がしやすいフレームワークという特徴も持っている。<br><br>
            (3)：Spring Framework［DI（Dependency Injection）コンテナと呼ばれる、
                環境に依存する機能を外部から提供可能とする方法が特徴的なオープンソースの
                フレームワーク］<br>
                特徴：Springはオブジェクトの関連付け、生成、登録などを管理する
                「Coreモジュール」、JavaBeansへのアクセス機能を提供する
                「Context モジュール」、MVCモデルでの開発を提供する
                「Web MVCモジュール」など7種類のモジュールで構成されている。<br>
        </h1>
    </body>
</html>
