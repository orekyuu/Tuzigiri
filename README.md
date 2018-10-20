# Tuzigiri
*またつまらぬPRを送ってしまった。*

TuzigiriはオープンソースのGitHubのコントリビューターを探すためのリポジトリシェアサービスです。  
見知らぬ誰かのリポジトリにプルリクエストを送ったり、リポジトリをシェアしてあなたの素敵なライブラリやプロダクトにプルリクエストを貰いましょう🎉

# なぜオープンソース？
Tuzigiriは実験的リポジトリでもあります。  
Javaエンジニアが業務で出会う無理な仕様変更、難しい設計たちとどう戦うかこのサービスを題材に議論をしましょう。  
あなたのエンジニア知見をコミュニティにシェアしましょう！

# 開発や議論に参加する

[Tuzigiri slack](https://join.slack.com/t/tuzigiri/shared_invite/enQtNDM2MTcyNzE2MzIzLWMwM2I1YmNjMzE0ODc4ZGJjY2FmY2MyOTA4NWE3NjdhNzk4YzI5OGFkNmM5ZGViODI1YmE3ZWExNTEyN2RjNDI) に参加してください

# 起動方法

## 起動に必要なもの

- Docker

## 起動手順

```
git clone git@github.com:orekyuu/Tuzigiri.git
cd Tuzigiri
docker-compose up
```

## 動作確認

[http://localhost/](http://localhost/)にアクセスします。

# ビルド方法

## ビルドに必要なもの

- Docker
- JDK 11+
- vue-cli

## ビルド手順

1. データベースの立ち上げ
```
cd Tuzigiri/infra
docker-compose up -d
```

2. hostsの設定

```
127.0.0.1   tuzigiri-db
127.0.0.1   api.tuzigiri.localhost #例です
127.0.0.1   tuzigiri.localhost #例です
```

3. Springの立ち上げ

```
./gradlew bootRun
```

4. Nuxtの立ち上げ

```
npm install #初回のみ
npm run dev
```

## 動作確認

[http://tuzigiri.localhost/](http://tuzigiri.localhost/)にアクセスします。

