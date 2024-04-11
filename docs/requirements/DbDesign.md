
# DB設計

- [draw.ioで記載したページはここから](https://app.diagrams.net/?libs=general;uml#G1pHGSZN4woETAQgbwX-AAX2DjZZikdT2w#%7B%22pageId%22%3A%22C5RBs43oDa-KdzZeNtuy%22%7D)

### Table: Users

| Column     | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description     |
|------------|---------------|-----------|-------------|-------------|----------|-----------------|
| user_id    | ユーザーID        | INT       | ○           |             |          |  |
| username   | ユーザー名         | VARCHAR   |             |             |          | ユーザーのユーザー名      |
| email      | メールアドレス       | VARCHAR   |             |             |          | ユーザーのメールアドレス    |
| password   | パスワード         | VARCHAR   |             |             |          | 認証パスワード         |
| created_at | 作成日時          | TIMESTAMP |             |             |          |                 |
| updated_at | 更新日時          | TIMESTAMP |             |             |          |                 |
| version      | バージョン        | INT       |             |             |        |                     |


### Table: Purposes (目的)

| Column      | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description    |
|-------------|---------------|-----------|-------------|-------------|----------|----------------|
| purpose_id  | 目的ID          | INT       | ○           |             |          |    |
| user_id     | ユーザーID        | INT       |             | ○           |          | Usersテーブルの外部キー |
| description | 説明            | TEXT      |             |             | ○        | 目的の説明          |
| created_at  | 作成日時          | TIMESTAMP |             |             |          |                |
| updated_at  | 更新日時          | TIMESTAMP |             |             |          |                |
| version      | バージョン        | INT       |             |             |        |                     |


### Table: Goals (目標)

| Column       | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description          |
|--------------|---------------|-----------|-------------|-------------|----------|----------------------|
| goal_id      | 目標ID            | INT       | ○           |       |          |  |
| user_id      | ユーザーID          | INT       |             | ○      |          | Usersテーブルの外部キー    |
| purpose_id   | 目的ID            | INT       |             | ○      |          | Purposesテーブルの外部キー |
| description  | 説明             | TEXT      |             |        |          | 目標の説明      |
| created_at   | 作成日時          | TIMESTAMP |             |        |          |  |
| updated_at  | 更新日時          | TIMESTAMP |             |             |          |                |
| version      | バージョン        | INT       |             |             |        |                     |


### Table: Tasks

| Column          | Japanese name | Data Type  | Primary_key | Foreign_key | Nullable | Description                                                       |
|-----------------|---------------|------------|-------------|-------------|--------|-------------------------------------------------------------------|
| task_id         | タスクID           | INT        | ○        |             |        |                                            |
| goal_id         | 目標ID            | INT        |             | ○        |        | Goalsテーブルを参照する外部キー                                     |
| parent_task_id  | 親タスクID         | INT        |             | ○        | ○      | 親タスクを参照する外部キー                                |
| description     | 説明             | TEXT       |             |             | ○      | タスクの説明                                                       |
| priority        | 優先度            | INT        |             |             | ○      | タスクの優先度                   |
| due_date        | 期日             | DATE       |             |             | ○      | タスクの期限                                                       |
| completed       | 完了フラグ         | BOOLEAN    |             |             | ○      | タスクが完了したかどうかを示すフラグ                                  |
| created_at   | 作成日時          | TIMESTAMP |             |        |          |  |
| updated_at  | 更新日時          | TIMESTAMP |             |             |          |                |
| version      | バージョン        | INT       |             |             |        |                     |

### Table: Task_Comments

| Column           | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description                                          |
|------------------|---------------|-----------|-------------|-------------|----------|------------------------------------------------------|
| task_comment_id  | タスクコメントID     | INT       | ○        |             |          | 各タスクコメントの一意の識別子                                 |
| task_id          | タスクID           | INT       |             | ○        |          | Tasksテーブルを参照する外部キー                                |
| user_id          | ユーザーID         | INT       |             | ○        |          | Usersテーブルを参照する外部キー                                |
| content          | 内容             | TEXT      |             |             | ○        | コメントの内容                                                    |
| created_at   | 作成日時          | TIMESTAMP |             |        |          |  |
| updated_at  | 更新日時          | TIMESTAMP |             |             |          |                |
| version      | バージョン        | INT       |             |             |        |                     |


### Table: Articles

| Column      | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description          |
|-------------|---------------|-----------|-------------|-------------|---------|----------------------|
| article_id  | 記事ID            | INT       | ○        |             |         |                      |
| user_id     | ユーザーID         | INT       |             | ○        |         | Usersテーブルを参照する外部キー   |
| title       | タイトル           | VARCHAR   |             |             |         | 記事のタイトル              |
| content     | 内容             | TEXT      |             |             | ○       | 記事の内容                |
| image_url   | 画像URL          | VARCHAR   |             |             | ○       | 記事の画像のURL            |
| is_draft    | 下書きフラグ        | BOOLEAN   |             |             |        | 記事が下書きであるかどうかを示すフラグ  |
| is_public   | 公開フラグ          | BOOLEAN   |             |             |       | 記事が公開されているかどうかを示すフラグ |
| created_at   | 作成日時          | TIMESTAMP |             |        |         |                      |
| updated_at  | 更新日時          | TIMESTAMP |             |             |         |                      |
| version      | バージョン        | INT       |             |             |        |                     |


### Table: Article_Likes

| Column         | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description                                      |
|----------------|---------------|-----------|-------------|-------------|----------|--------------------------------------------------|
| like_id        | いいねID          | INT       | ○           |             |          | 各いいねの一意の識別子                            |
| article_id     | 記事ID            | INT       |             | ○           |          | Articlesテーブルを参照する外部キー                |
| user_id        | ユーザーID         | INT       |             | ○           |          | Usersテーブルを参照する外部キー                   |
| created_at   | 作成日時          | TIMESTAMP |             |             |          |  |
| updated_at  | 更新日時          | TIMESTAMP |             |             |          |                |
| version      | バージョン        | INT       |             |             |        |                     |


### Table: Article_Comments

| Column         | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description                                      |
|----------------|---------------|-----------|-------------|-------------|----------|--------------------------------------------------|
| comment_id     | コメントID        | INT       | ○           |             |          |                          |
| article_id     | 記事ID            | INT       |             | ○           |          | Articlesテーブルを参照する外部キー                |
| user_id        | ユーザーID         | INT       |             | ○           |          | Usersテーブルを参照する外部キー                   |
| content        | 内容             | TEXT      |             |             | ○        | コメントの内容                                    |
| created_at   | 作成日時          | TIMESTAMP |             |             |          |  |
| updated_at  | 更新日時          | TIMESTAMP |             |             |          |                |
| version      | バージョン        | INT       |             |             |        |                     |

### Table: Article_Footprints

| Column         | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description                                     |
|----------------|---------------|-----------|-------------|-------------|----------|-------------------------------------------------|
| footprint_id   | 足跡ID           | INT       | ○           |             |          |                               |
| article_id     | 記事ID            | INT       |             | ○           |          | Articlesテーブルを参照する外部キー                |
| user_id        | ユーザーID         | INT       |             | ○           |          | Usersテーブルを参照する外部キー                   |
| created_at   | 作成日時          | TIMESTAMP |             |             |          |  |
| updated_at  | 更新日時          | TIMESTAMP |             |             |          |                |
| version      | バージョン        | INT       |             |             |        |                     |


### Table: Tweets

| Column       | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description                                      |
|--------------|---------------|-----------|-------------|-------------|----------|--------------------------------------------------|
| tweet_id     | ツイートID       | INT       | ○           |             |          |                          |
| user_id      | ユーザーID       | INT       |             | ○           |          | Usersテーブルを参照する外部キー                   |
| content      | 内容            | TEXT      |             |             | ○        | ツイートの内容                                    |
| created_at   | 作成日時          | TIMESTAMP |             |             |          |  |
| updated_at  | 更新日時          | TIMESTAMP |             |             |          |                |
| version      | バージョン        | INT       |             |             |        |                     |

### Table: Tweets_comments

| Column         | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description                                      |
|----------------|---------------|-----------|-------------|-------------|----------|--------------------------------------------------|
| comment_id     | コメントID        | INT       | ○           |             |          |                          |
| tweet_id       | ツイートID        | INT       |             | ○           |          | Tweetsテーブルを参照する外部キー                   |
| user_id        | ユーザーID         | INT       |             | ○           |          | Usersテーブルを参照する外部キー                   |
| content        | 内容             | TEXT      |             |             | ○        | コメントの内容                                    |
| created_at   | 作成日時          | TIMESTAMP |             |             |          |  |
| updated_at  | 更新日時          | TIMESTAMP |             |             |          |                |
| version      | バージョン        | INT       |             |             |        |                     |


### Table: Tweets_likes

| Column       | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description                                      |
|--------------|---------------|-----------|-------------|-------------|----------|--------------------------------------------------|
| like_id      | いいねID         | INT       | ○           |             |          |                             |
| tweet_id     | ツイートID       | INT       |             | ○           |          | Tweetsテーブルを参照する外部キー                   |
| user_id      | ユーザーID       | INT       |             | ○           |          | Usersテーブルを参照する外部キー                   |
| created_at   | 作成日時          | TIMESTAMP |             |             |          |  |
| updated_at  | 更新日時          | TIMESTAMP |             |             |          |                |
| version      | バージョン        | INT       |             |             |        |                     |

### Table: Events

| Column       | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description        |
|--------------|---------------|-----------|-------------|-------------|----------|--------------------|
| event_id     | イベントID        | INT       |○          |             |          |                    |
| user_id      | ユーザーID       | INT       |             |○         |          | Usersテーブルを参照する外部キー |
| title       | タイトル           | VARCHAR   |             |             |         | イベントのタイトル          |
| description  | 説明            | TEXT      |             |             |       | イベントの説明            |
| image_url   | 画像URL          | VARCHAR   |             |             | ○       | 記事の画像のURL            |
| created_at   | 作成日時          | TIMESTAMP |             |             |          |                    |
| updated_at  | 更新日時          | TIMESTAMP |             |             |          |                    |
| version      | バージョン        | INT       |             |             |        |                     |

### Table: EventsComments

| Column         | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description                                      |
|----------------|---------------|-----------|-------------|-------------|-------|--------------------------------------------------|
| comment_id     | コメントID        | INT       | ○           |             |       | 各コメントの一意の識別子                         |
| event_id       | イベントID        | INT       |             | ○           |       | Eventsテーブルを参照する外部キー                   |
| user_id        | ユーザーID         | INT       |             | ○           |       | Usersテーブルを参照する外部キー                   |
| content        | 内容             | TEXT      |             |             |    | コメントの内容                                    |
| created_at     | 作成日時          | TIMESTAMP |             |             |       |                          |
| updated_at  | 更新日時          | TIMESTAMP |             |             |       |                    |
| version      | バージョン        | INT       |             |             |        |                     |

### Table: EventsLikes

| Column       | Japanese name | Data Type | Primary_key | Foreign_key | Nullable | Description                                      |
|--------------|---------------|-----------|-------------|-------------|--------|--------------------------------------------------|
| like_id      | いいねID         | INT       | ○           |             |        | 各いいねの一意の識別子                            |
| event_id     | イベントID        | INT       |             | ○           |        | Eventsテーブルを参照する外部キー                   |
| user_id      | ユーザーID       | INT       |             | ○           |        | Usersテーブルを参照する外部キー                   |
| created_at   | 作成日時         | TIMESTAMP |             |             |        |                             |
| updated_at  | 更新日時          | TIMESTAMP |             |             |       |                    |
| version      | バージョン        | INT       |             |             |        |                     |





