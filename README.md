# TwitchNot
Discord&amp;Twitch бот

Простой чат-бот для Discord. Он уведомляет о начале прямой трансляции на канале www.twitch.tv

## Использование

Укажите в файле config.json название канала и текст уведомления, где:
 - `%channel%` - отображаемое название канала
 - `%text%` - текст оповещения

Например:
```json
{
    "channel":"mirongaming",
    "text":"Начался стрим на twitch канале %channel%! \nНазвание: %name% \nИгра: %game% \nСсылка: %url%"
}
```
