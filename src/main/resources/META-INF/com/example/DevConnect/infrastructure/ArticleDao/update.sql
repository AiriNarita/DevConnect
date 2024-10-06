UPDATE articles
SET
    user_id = /* entity.userId */0,
    content = /* entity.content */'',
    title = /* entity.title */'',
    image_url = /* entity.imageUrl */'',
    public_status = /* entity.publicStatus */0,
    version = version + 1 -- バージョンはインクリメント
WHERE
    article_id = /* entity.articleId */0
AND
    version = /* entity.version */0 -- 現在のバージョンが一致しているかを確認
