package com.example.alephbeth_android

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.alephbeth_android.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*

//----------------------------------------------------------------------------

@Serializable
data class HebrewLetterList (
    val alephbeth: List<HebrewLetter>
)

@Serializable
data class HebrewLetter (
	val id: Int,
	val name: NameList,
	val script: String,
	val sofit: Boolean,
	val dagesh: Boolean,
	val original: Int,
	val explanation: String,
)

@Serializable
data class NameList (
	val HebrewAcademy2006: String = "",
	val Lambdin: String = "",
)

val HebrewLetterJson = """
{"alephbeth": [
	{
		"id": 0,
		"name": {
			"HebrewAcademy2006": "alef",
			"Lambdin": "ʾā́lep̄"
		},
		"script": "א",
		"sofit": false,
		"dagesh": false,
		"original": 0,
		"explanation": "某宗教団体のことを思い出す人もいるかもしれないアレフ。ラテンアルファベットのAにあたる。Aの横画を突き出させて90°左に回せばそう見えないこともない。あるいは右下に小さく0とかけば数学における可算無限の濃度を表すことができる。何にせよせいぜい日常生活で触れることのできるヘブライ文字なんてアレフくらいだろう。斜めの線を最初に引くのがおすすめ。筆記体だとKにしか見えない。子音としてはア行の担当。つまり子音なし。"
	},
	{
		"id": 1,
		"name": {
			"HebrewAcademy2006": "vet",
			"Lambdin": "ḇêṯ"
		},
		"script": "ב",
		"sofit": false,
		"dagesh": false,
		"original": 1,
		"explanation": "ヴェート。あるいはヴェイトに聞こえる。バイトといえば家という単語になる。何となく家に見えなくもない。だけど完全にカタカナのユ。ユは二画だけど筆記体の時は右回りで一画で書いちゃう。後述のכと似てるんだけど下の線が独立して右に突き出してるのがヴェートです。筆記体の時はこのכと区別をつけるために下のあたりで一旦跳ねます。右上のところは丸く書いたほうがポイですよ。"
	},
	{
		"id": 2,
		"name": {
			"HebrewAcademy2006": "bet",
			"Lambdin": "bêṯ"
		},
		"script": "בּ",
		"sofit": false,
		"dagesh": true,
		"original": 1,
		"explanation": "ベート、あるいはベイト。בがvを担当するのに対し、ダゲッシュつきのבּの方はbを担当します。余談だが聖書はこの文字で始まる。vが重なるとbになるのか？　真ん中に点があるとかわいいよね。筆記体に点書いたらもうなんかネズミっぽいというか。"
	},
	{
		"id": 3,
		"name": {
			"HebrewAcademy2006": "gimel",
			"Lambdin": "ḡîmel"
		},
		"script": "ג",
		"sofit": false,
		"dagesh": false,
		"original": 3,
		"explanation": "ギメル。大怪獣ギメルとでもいうべき荘厳な響き。しかしその実、ガマルといえばラクダの意味。お前...。גの見かけは何となく首をもたげているように見えるがラクダにしては後ろが短い。むしろ首を出したネッシー？　ギリシャ文字のガンマ（Γ,γ）にあたる文字なんだけどあんまり似てない。むしろ逆さ。そうか、逆さまのガンマなんだ。"
	},
	{
		"id": 4,
		"name": {
			"Lambdin": "gîmel"
		},
		"script": "גּ",
		"sofit": false,
		"dagesh": true,
		"original": 3,
		"explanation": "ギメルのダゲッシュ。現代ではギメルはダゲッシュがつくかつかないかでは発音は変化しないが、過去には区別があったらしい。"
	},
	{
		"id": 5,
		"name": {
			"HebrewAcademy2006": "dalet",
			"Lambdin": "ḏā́leṯ"
		},
		"script": "ד",
		"sofit": false,
		"dagesh": false,
		"original": 5,
		"explanation": "ダレット。デレットといえば扉の意味。扉にしては線が足りないが。後述のרと似ているがこっちは角ばっていて、右に飛び出している。丸く描くとרで違う文字なので注意。二画に分けたほうがいいかも。カクカクしているという一点においてはギリシャ文字のデルタ（Δ）　に近いだろうか。あんまり真ん中に縦線を寄せてしまうとזと似てくるので注意。十分に横画を長くすること。順番に覚えるときは、個人的にはアレフからここまで四文字を一息で言いたい。「アレフ、ヴェート、ギメル、ダレット！」"
	},
	{
		"id": 6,
		"name": {
			"Lambdin": "dā́leṯ"
		},
		"script": "דּ",
		"sofit": false,
		"dagesh": true,
		"original": 5,
		"explanation": "ダゲッシュつきダレット。過去区別があったがこれも現代では発音の区別なし。"
	},
	{
		"id": 7,
		"name": {
			"HebrewAcademy2006": "he",
			"Lambdin": "hē"
		},
		"script": "ה",
		"sofit": false,
		"dagesh": false,
		"original": 7,
		"explanation": "ヘイ。何と気の抜けた響き。同じ音でそのまま感嘆詞になる。もちろん意味は「ヘイ！」ヘイヘイヘイヘイ、マイムマイムマイムマイム...♪。左の縦線が長くなるとחと同じになってしまうので、全体の高さの半分くらいでいいと思われる。右上は尖ってても丸くても大丈夫。どうせ筆記体がすごく丸い。ちなみにこの文字一文字で定冠詞になる。"
	},
	{
		"id": 8,
		"name": {
			"HebrewAcademy2006": "vav",
			"Lambdin": "wāw"
		},
		"script": "ו",
		"sofit": false,
		"dagesh": false,
		"original": 8,
		"explanation": "ヴァヴ。かぎ針の意味。書体によっては上のほうが少しだけ左に曲がっていて、なおかぎ針らしい。問題はこの文字、長さで似てる文字に取り違えられる可能性がある。短いとיだし、長すぎるとןだ。通常の文字の大きさの上から下までちょうど。決して基準線の下まで伸ばしてはいけない。この一文字で接続詞「そして」の意味になる。確かに他の単語にちょっと「そして...」と付け足すには簡単だ。書くときは詰めて書いていい。"
	},
	{
		"id": 9,
		"name": {
			"HebrewAcademy2006": "zayin",
			"Lambdin": "záyin"
		},
		"script": "ז",
		"sofit": false,
		"dagesh": false,
		"original": 9,
		"explanation": "ザイン。上にある横画は何となく右に下げておくと通。しかしどっこい、筆記体になるとむしろ一旦左に傾く。めっちゃ混乱する。Zと似てなくもない。ちょっとしたが足りないけど。しかし小文字のゼータ（ζ)と比べると...筆記体は完全に左右反転してるじゃないですか！　Tと似てるけど音が違うので注意。横幅は割と狭い。音読はここで第二区切り。一緒に声に出して。「ヘイ、ヴァヴ、ザイン！」"
	},
	{
		"id": 10,
		"name": {
			"HebrewAcademy2006": "ẖet",
			"Lambdin": "ḥēṯ"
		},
		"script": "ח",
		"sofit": false,
		"dagesh": false,
		"original": 10,
		"explanation": "ヘット。ただの「へ」ではない。喉の奥に息を当てるやつ。ドイツ語のchの音が近いらしい。הに似てるけど必ず左の縦線を上にくっつけること。そして縦線のほうが長く上に突き出しても可。筆記体だとむしろ積極的に突き出す。活字体でも上に出てる書体があった（気がする）。イメージとしては閉じてないとה（ヘイ）で力が抜けた音だけど、閉じると力が籠もってח（ヘット！）となる。イメージなので合わなかったら無視してください。"
	},
	{
		"id": 11,
		"name": {
			"HebrewAcademy2006": "tet",
			"Lambdin": "ṭēṯ"
		},
		"script": "ט",
		"sofit": false,
		"dagesh": false,
		"original": 11,
		"explanation": "テット。右回りにぐるっと一息に書いて上に投げる。ポーン。筆の始まりとくっつけて閉じてしまうとסになってしまうので注意。あくまで上は開けておく。なんか誰かの鼻みたいだよね。תと同じタ行を担当する子音だけど、現代の発音では多分二つに違いはない。綴りの違いとしてだけ意識して。"
	},
	{
		"id": 12,
		"name": {
			"HebrewAcademy2006": "yud",
			"Lambdin": "yōḏ"
		},
		"script": "י",
		"sofit": false,
		"dagesh": false,
		"original": 12,
		"explanation": "ユッド。ヨッド(yod)とも言う。子音としてはヤ行を担当。とにかく小さい。印刷で見るとなんかゴミなんじゃないかと思ったりするけどこれで一文字。一点と言うよりは、ちょっと左に払う。アポストロフィーみたいに一旦丸めたりはしない。短い縦線でもあり。上に行きすぎると違う記号(’)とかに見えてしまうので、あくまで他の文字の上はしと同じ高さから下げること。つまり「בּית」この高さ。例えば「תנ”ך」のように書くとこれは省略語を書くための記号になる。やっぱりちょっと丸いのが大事かも。"
	},
	{
		"id": 13,
		"name": {
			"HebrewAcademy2006": "khaf",
			"Lambdin": "ḵap̄"
		},
		"script": "כ",
		"sofit": false,
		"dagesh": false,
		"original": 13,
		"explanation": "ハフ。この「ハ」もただのハじゃなくて喉を擦ってる感じ。いくらかkに近いけどkではない。実際現代のイスラエル人はח（ヘット）とכ（ハフ）の子音を区別はしていないらしい。聖書朗読するラビたちは区別しているのかもしれないが。カタカナのコに近いが、一角で右回りに書いたほうがいい。丸く書くのがおすすめだが、したの部分が足りないとרと区別が付かなくなる。十分に丸く囲んで。音読の区切りはここまで。「ヘット、テット、ユッド、ハフ！」"
	},
	{
		"id": 14,
		"name": {
			"HebrewAcademy2006": "kaf",
			"Lambdin": "kap̄"
		},
		"script": "כּ",
		"sofit": false,
		"dagesh": true,
		"original": 13,
		"explanation": "カフ。掌、足の裏とかスプーンの意味。こっちは明確にカ行。こういうアン○ーンいそう。"
	},
	{
		"id": 15,
		"name": {
			"HebrewAcademy2006": "khaf sofit",
			"Lambdin": "ḵap̄ sôp̄îṯ"
		},
		"script": "ך",
		"sofit": true,
		"dagesh": false,
		"original": 13,
		"explanation": "語末形（ソフィート）第一の刺客。כの折れ曲がっていた最後のカーブをまっすぐにして下に伸ばす。ノートの横線を突き刺す勢いで下に伸ばす。伸ばさないとרに見える。そもそもרとךの見分けつきます？　かなり初心者泣かせだが、あくまでכとセットで覚えたほうがいい。これに限らず、語末形は「最後のカーブを伸ばす」のが特徴。"
	},
	{
		"id": 16,
		"name": {
			"HebrewAcademy2006": "lamed",
			"Lambdin": "lā́meḏ"
		},
		"script": "ל",
		"sofit": false,
		"dagesh": false,
		"original": 16,
		"explanation": "ラメッド。何だか雷に見える。ラ行だけどLの音の方。Rは後で出てくる。この文字は他の文字に比べて上に突き出している。למדといった具合に。聖書ではこんなレベルではない、上の行よりもっと行ったんじゃないか、いやページから突き出したいんじゃないかってくらい上に伸びてる時がある。しかも曲がる。一応上から書くけど、筆記体のときは下から書く。"
	},
	{
		"id": 17,
		"name": {
			"HebrewAcademy2006": "mem",
			"Lambdin": "mēm"
		},
		"script": "מ",
		"sofit": false,
		"dagesh": false,
		"original": 17,
		"explanation": "メム。右回りに丸く書くやつと左上のちょっと出てるやつを分けて書く。筆記体は...どうしてこうなった？　Nやん。見た目はネズミ、あるいは尾根。何となく見つめられている気分になる。"
	},
	{
		"id": 18,
		"name": {
			"HebrewAcademy2006": "mem sofit",
			"Lambdin": "mēm sôp̄îṯ"
		},
		"script": "ם",
		"sofit": true,
		"dagesh": false,
		"original": 17,
		"explanation": "語末形第二の刺客。原則と異なり、こいつは何だが四角くなる。左上から初めて右、下、左と一画で書いたのち、左上から下へ縦画を書いて閉じる。右上だけなんだが丸いように見えるが...。複数名詞がこれで終わるものが多いので結構頻繁に書くことになる文字。"
	},
	{
		"id": 19,
		"name": {
			"HebrewAcademy2006": "nun",
			"Lambdin": "nûn"
		},
		"script": "נ",
		"sofit": false,
		"dagesh": false,
		"original": 19,
		"explanation": "ヌン。聖書に出てくるフレーズで言うと「ヌンの子、ヨシュア」のヌン。ぬーん。横幅が狭いのが特徴。広いとכになってしまう。最後に左に出すのを忘れるとוと間違われる。通称ホッチキス。ננננננננ。ホッチキスといえば]のほうが有名かな。]]]]]]]]。大小様々なホッチキスがありますね。音読はここで区切り。実はラテンアルファベットのL、M、Nがここで続いている。「ラメッド、メム、ヌン！」"
	},
	{
		"id": 20,
		"name": {
			"HebrewAcademy2006": "nun sofit",
			"Lambdin": "nûn sôp̄îṯ"
		},
		"script": "ן",
		"sofit": true,
		"dagesh": false,
		"original": 19,
		"explanation": "語末形第三の刺客。基準線を超えて下に突き刺す。結構長い。間違えやすいユッド、ヴァヴと並べるとיוןとなる。ほら、ヌンが一番長いでしょ？（狂気）語末形じゃないנの最後の曲がり角がまっすぐになったと考えて良い。"
	},
	{
		"id": 21,
		"name": {
			"HebrewAcademy2006": "samekh",
			"Lambdin": "sā́meḵ"
		},
		"script": "ס",
		"sofit": false,
		"dagesh": false,
		"original": 21,
		"explanation": "サメフ。上ないし左上から始めて右回りにぐるっと一回り、そして必ず閉じる。Oに見えるけど発音はS。ギリシャ文字のシグマ（σ）を知っていると、それと左右反転した形になっている。発音も同じ。何となく盾に見えるよね。あるいはコブラ。"
	},
	{
		"id": 22,
		"name": {
			"HebrewAcademy2006": "ayin",
			"Lambdin": "ʿáyin"
		},
		"script": "ע",
		"sofit": false,
		"dagesh": false,
		"original": 22,
		"explanation": "アイン。泉の意味。もともとは喉をどうかする子音だったらしいけど現在では何もなし、ア行の発音。אと一緒。しかしそのもともとの子音は結構キツかったようで、「ソドム、ゴモラの街」と言う時の「ゴ」の音はこれ。どうして消えた。何となくyに見えるけど、右の縦線から書き始める。そして右の線が横向きになったところで左の縦線とくっつきたい。筆記体になるとガンマの小文字を逆から書いたみたいになる。"
	},
	{
		"id": 23,
		"name": {
			"HebrewAcademy2006": "fe",
			"Lambdin": "p̄ēh"
		},
		"script": "פ",
		"sofit": false,
		"dagesh": false,
		"original": 23,
		"explanation": "フェー、あるいはフェイ。fの音を担当。ファ行だと思っていい。左上から下、右とクルクルしたところを先に書いてから、再度左上から始めて右回りにぐるっと書く。筆記体になるとなぜかクルクルは最後に移行。"
	},
	{
		"id": 24,
		"name": {
			"HebrewAcademy2006": "pe",
			"Lambdin": "pēh"
		},
		"script": "פּ",
		"sofit": false,
		"dagesh": true,
		"original": 23,
		"explanation": "ペー、あるいはペイ。口の意味。点を打つところ何となく迷うけど一画目が終わった延長線上に打っておくイメージ。"
	},
	{
		"id": 25,
		"name": {
			"HebrewAcademy2006": "fe sofit",
			"Lambdin": "p̄ēh sôp̄îṯ"
		},
		"script": "ף",
		"sofit": true,
		"dagesh": false,
		"original": 23,
		"explanation": "語末形第四の刺客。下に伸びる。ブッ刺さる。問題は筆記体の方で、なぜか上にト音記号みたいなのを生やす。したから書く。上行ってから下に戻ってくる時の結び方は色々あって小洒落てくる。初見でこれがףだと分かるやつはいないだろう。"
	},
	{
		"id": 26,
		"name": {
			"HebrewAcademy2006": "tsadi",
			"Lambdin": "ṣāḏēh"
		},
		"script": "צ",
		"sofit": false,
		"dagesh": false,
		"original": 26,
		"explanation": "ツァディ。ひらがなの「と」かと思った？　ザーンネン、左右反転型でした！　実際これヘブライ文字自分なれてきたなと思っても間違える。書き順まで「と」と逆。つまり左上から初めて折れ曲がった線を先に書く。そして筆記体。どうして上に行こうと思った？　原型とどめてないが、他の文字の倍くらいの高さからグルグルする。דの筆記体は大体他の文字と同じ高さからグルグルする。何だかロシア語で似たようなの見た気がするけど気のせい。音読の区切り。「サメフ、アイン、フェー、ツァディ！」"
	},
	{
		"id": 27,
		"name": {
			"HebrewAcademy2006": "tsadi sofit",
			"Lambdin": "ṣāḏēh sôp̄îṯ"
		},
		"script": "ץ",
		"sofit": true,
		"dagesh": false,
		"original": 26,
		"explanation": "語末形最後の刺客。最初の斜めからの折れ曲がり線がまっすぐになってしかも下向きに直ってる。深く突き刺した後に枝をつける。そして筆記体はそれの反動だろうか。高く浮かび上がった上に頭上で輪を描いてしまった。これもいろんな書体があるけどとりあえず上の方で丸くなってたらツァディの語末形。何となく下に戻ってきてたらフェーの語末形。"
	},
	{
		"id": 28,
		"name": {
			"HebrewAcademy2006": "kuf",
			"Lambdin": "qōp"
		},
		"script": "ק",
		"sofit": false,
		"dagesh": false,
		"original": 28,
		"explanation": "クフ。コフとも言う。コフは猿の意味。だんだん猿の頭に見えてきた。アルファベットではqで転写することもあるけど発音は多分kで大丈夫。qっていうよりはpだよね。それからカタカナの「ア」に見える。書き順もアでok。下に突き刺さっている。"
	},
	{
		"id": 29,
		"name": {
			"HebrewAcademy2006": "resh",
			"Lambdin": "rēs̆"
		},
		"script": "ר",
		"sofit": false,
		"dagesh": false,
		"original": 29,
		"explanation": "レーシュ。ローシュというと頭の意味。Rの音担当で、巻き舌でもあり。とはいえrと逆向きだ。まあ対応なんてそんなもんだよね。"
	},
	{
		"id": 30,
		"name": {
			"HebrewAcademy2006": "shin",
			"Lambdin": "s̆în"
		},
		"script": "שׁ",
		"sofit": false,
		"dagesh": false,
		"original": 30,
		"explanation": "シン。shの音担当。右上に点がついてるけど、これはダゲッシュではなくて（ダゲッシュがつく可能性もあるけどそれは真ん中にくる）、次のスィンと区別するための点。ヘブライ語は古くからsとshの区別があったようで、「お前、シボレテ(שׁבלת)って言ってみろ。（言えなくてスィボレテになったらお前は外国人だ）」という話が聖書に残っている。書き方は右上から下を通って左上まで器を作り、真ん中の線を最後に足す。筆記体ではその作業を一まとめにして右回りに一画で書く。"
	},
	{
		"id": 31,
		"name": {
			"HebrewAcademy2006": "sin",
			"Lambdin": "śîn"
		},
		"script": "שׂ",
		"sofit": false,
		"dagesh": false,
		"original": 31,
		"explanation": "スィン。こっちは左上に点がある。סと音がかぶるけど現代においては多分区別はない。辞書だとこの二つが違う文字として並んでる時も（つまりシンで始まる単語が全て終わってからスィンが語頭の単語が始まる、可能性としてはその逆も）あるので注意して。"
	},
	{
		"id": 32,
		"name": {
			"HebrewAcademy2006": "tav",
			"Lambdin": "ṯāw"
		},
		"script": "ת",
		"sofit": false,
		"dagesh": false,
		"original": 32,
		"explanation": "タブ。印の意味。左上から右に伸びる画を最初に書く。左の縦線はそのまま下ろしてもいいけど、最後左に少し伸ばして足を作ると区別しやすい。筆記体になると天辺が尖って三角になる。さあ一緒に声を出して。「クフ、レーシュ、シン、タヴ！」"
	},
	{
		"id": 33,
		"name": {
			"Lambdin": "tāw"
		},
		"script": "תּ",
		"sofit": false,
		"dagesh": false,
		"original": 32,
		"explanation": "タヴのダゲッシュ。場合によっては（古い発音において？）こっちがtの発音で、ダゲッシュがついてない時には、いわゆるthの発音になると考えられる時もある。"
	}
]
}
"""

val hebrewLetters = Json.decodeFromString<HebrewLetterList>(HebrewLetterJson)

//----------------------------------------------------------------------------

class RememberHebrewChar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remember_hebrew_char)

        //KotlinもAndroidもまじで分からない…誰か助けて…笑
        var btnHebrewChar1 = findViewById<Button>(R.id.hebrewChar_1)
        btnHebrewChar1.text = hebrewLetters.alephbeth[0].script + "   " + hebrewLetters.alephbeth[0].name.Lambdin
        var btnHebrewChar2 = findViewById<Button>(R.id.hebrewChar_2)
        btnHebrewChar2.text = hebrewLetters.alephbeth[1].script + "   " + hebrewLetters.alephbeth[1].name.Lambdin
        var btnHebrewChar3 = findViewById<Button>(R.id.hebrewChar_3)
        btnHebrewChar3.text = hebrewLetters.alephbeth[2].script + "   " + hebrewLetters.alephbeth[2].name.Lambdin
        var btnHebrewChar4 = findViewById<Button>(R.id.hebrewChar_4)
        btnHebrewChar4.text = hebrewLetters.alephbeth[3].script + "   " + hebrewLetters.alephbeth[3].name.Lambdin
        var btnHebrewChar5 = findViewById<Button>(R.id.hebrewChar_5)
        btnHebrewChar5.text = hebrewLetters.alephbeth[4].script + "   " + hebrewLetters.alephbeth[4].name.Lambdin
        var btnHebrewChar6 = findViewById<Button>(R.id.hebrewChar_6)
        btnHebrewChar6.text = hebrewLetters.alephbeth[5].script + "   " + hebrewLetters.alephbeth[5].name.Lambdin
        var btnHebrewChar7 = findViewById<Button>(R.id.hebrewChar_7)
        btnHebrewChar7.text = hebrewLetters.alephbeth[6].script + "   " + hebrewLetters.alephbeth[6].name.Lambdin
        var btnHebrewChar8 = findViewById<Button>(R.id.hebrewChar_8)
        btnHebrewChar8.text = hebrewLetters.alephbeth[7].script + "   " + hebrewLetters.alephbeth[7].name.Lambdin
        var btnHebrewChar9 = findViewById<Button>(R.id.hebrewChar_9)
        btnHebrewChar9.text = hebrewLetters.alephbeth[8].script + "   " + hebrewLetters.alephbeth[8].name.Lambdin
        var btnHebrewChar10 = findViewById<Button>(R.id.hebrewChar_10)
        btnHebrewChar10.text = hebrewLetters.alephbeth[9].script + "   " + hebrewLetters.alephbeth[9].name.Lambdin
        var btnHebrewChar11 = findViewById<Button>(R.id.hebrewChar_11)
        btnHebrewChar11.text = hebrewLetters.alephbeth[10].script + "   " + hebrewLetters.alephbeth[10].name.Lambdin
        var btnHebrewChar12 = findViewById<Button>(R.id.hebrewChar_12)
        btnHebrewChar12.text = hebrewLetters.alephbeth[11].script + "   " + hebrewLetters.alephbeth[11].name.Lambdin
        var btnHebrewChar13 = findViewById<Button>(R.id.hebrewChar_13)
        btnHebrewChar13.text = hebrewLetters.alephbeth[12].script + "   " + hebrewLetters.alephbeth[12].name.Lambdin
        var btnHebrewChar14 = findViewById<Button>(R.id.hebrewChar_14)
        btnHebrewChar14.text = hebrewLetters.alephbeth[13].script + "   " + hebrewLetters.alephbeth[13].name.Lambdin
        var btnHebrewChar15 = findViewById<Button>(R.id.hebrewChar_15)
        btnHebrewChar15.text = hebrewLetters.alephbeth[14].script + "   " + hebrewLetters.alephbeth[14].name.Lambdin
        var btnHebrewChar16 = findViewById<Button>(R.id.hebrewChar_16)
        btnHebrewChar16.text = hebrewLetters.alephbeth[15].script + "   " + hebrewLetters.alephbeth[15].name.Lambdin
        var btnHebrewChar17 = findViewById<Button>(R.id.hebrewChar_17)
        btnHebrewChar17.text = hebrewLetters.alephbeth[16].script + "   " + hebrewLetters.alephbeth[16].name.Lambdin
        var btnHebrewChar18 = findViewById<Button>(R.id.hebrewChar_18)
        btnHebrewChar18.text = hebrewLetters.alephbeth[17].script + "   " + hebrewLetters.alephbeth[17].name.Lambdin
        var btnHebrewChar19 = findViewById<Button>(R.id.hebrewChar_19)
        btnHebrewChar19.text = hebrewLetters.alephbeth[18].script + "   " + hebrewLetters.alephbeth[18].name.Lambdin
        var btnHebrewChar20 = findViewById<Button>(R.id.hebrewChar_20)
        btnHebrewChar20.text = hebrewLetters.alephbeth[19].script + "   " + hebrewLetters.alephbeth[19].name.Lambdin
        var btnHebrewChar21 = findViewById<Button>(R.id.hebrewChar_21)
        btnHebrewChar21.text = hebrewLetters.alephbeth[20].script + "   " + hebrewLetters.alephbeth[20].name.Lambdin
        var btnHebrewChar22 = findViewById<Button>(R.id.hebrewChar_22)
        btnHebrewChar22.text = hebrewLetters.alephbeth[21].script + "   " + hebrewLetters.alephbeth[21].name.Lambdin
        var btnHebrewChar23 = findViewById<Button>(R.id.hebrewChar_23)
        btnHebrewChar23.text = hebrewLetters.alephbeth[22].script + "   " + hebrewLetters.alephbeth[22].name.Lambdin
        var btnHebrewChar24 = findViewById<Button>(R.id.hebrewChar_24)
        btnHebrewChar24.text = hebrewLetters.alephbeth[23].script + "   " + hebrewLetters.alephbeth[23].name.Lambdin
        var btnHebrewChar25 = findViewById<Button>(R.id.hebrewChar_25)
        btnHebrewChar25.text = hebrewLetters.alephbeth[24].script + "   " + hebrewLetters.alephbeth[24].name.Lambdin
        var btnHebrewChar26 = findViewById<Button>(R.id.hebrewChar_26)
        btnHebrewChar26.text = hebrewLetters.alephbeth[25].script + "   " + hebrewLetters.alephbeth[25].name.Lambdin
        var btnHebrewChar27 = findViewById<Button>(R.id.hebrewChar_27)
        btnHebrewChar27.text = hebrewLetters.alephbeth[26].script + "   " + hebrewLetters.alephbeth[26].name.Lambdin
        var btnHebrewChar28 = findViewById<Button>(R.id.hebrewChar_28)
        btnHebrewChar28.text = hebrewLetters.alephbeth[27].script + "   " + hebrewLetters.alephbeth[27].name.Lambdin
        var btnHebrewChar29 = findViewById<Button>(R.id.hebrewChar_29)
        btnHebrewChar29.text = hebrewLetters.alephbeth[28].script + "   " + hebrewLetters.alephbeth[28].name.Lambdin
        var btnHebrewChar30 = findViewById<Button>(R.id.hebrewChar_30)
        btnHebrewChar30.text = hebrewLetters.alephbeth[29].script + "   " + hebrewLetters.alephbeth[29].name.Lambdin
        var btnHebrewChar31 = findViewById<Button>(R.id.hebrewChar_31)
        btnHebrewChar31.text = hebrewLetters.alephbeth[30].script + "   " + hebrewLetters.alephbeth[30].name.Lambdin
        var btnHebrewChar32 = findViewById<Button>(R.id.hebrewChar_32)
        btnHebrewChar32.text = hebrewLetters.alephbeth[31].script + "   " + hebrewLetters.alephbeth[31].name.Lambdin
        var btnHebrewChar33 = findViewById<Button>(R.id.hebrewChar_33)
        btnHebrewChar33.text = hebrewLetters.alephbeth[32].script + "   " + hebrewLetters.alephbeth[32].name.Lambdin
        var btnHebrewChar34 = findViewById<Button>(R.id.hebrewChar_34)
        btnHebrewChar34.text = hebrewLetters.alephbeth[33].script + "   " + hebrewLetters.alephbeth[33].name.Lambdin

/*
        //1.画面遷移用ボタンの取得。
        val btnIntent1 = findViewById<Button>(R.id.hebrewChar_1)
        //2.画面遷移用ボタンにリスナを登録。
        btnIntent1.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?) {
                //3.Intentクラスのオブジェクトを生成。
                val intent = Intent(this@HebrewCharQuize, Detail::class.java)
                //生成したオブジェクトを引数に画面を起動！
                startActivity(intent)
            }
        })
*/
    }
}

class CustomListView : ListView {

    private val MAX_SIZE = 99

    constructor(context: Context?) : super(context) {
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var newHeight = 0
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        if (heightMode != MeasureSpec.EXACTLY) {
            val listAdapter: ListAdapter? = adapter
            if (listAdapter != null && !listAdapter.isEmpty) {
                var listPosition = 0
                listPosition = 0
                while (listPosition < listAdapter.count
                    && listPosition < MAX_SIZE
                ) {
                    val listItem: View = listAdapter.getView(listPosition, null, this)
                    if (listItem is ViewGroup) {
                        listItem.setLayoutParams(
                            LayoutParams(
                                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT
                            )
                        )
                    }
                    listItem.measure(widthMeasureSpec, heightMeasureSpec)
                    newHeight += listItem.getMeasuredHeight()
                    listPosition++
                }
                newHeight += dividerHeight * listPosition
            }
            if (heightMode == MeasureSpec.AT_MOST && newHeight > heightSize) {
                if (newHeight > heightSize) {
                    newHeight = heightSize
                }
            }
        } else {
            newHeight = measuredHeight
        }
        setMeasuredDimension(measuredWidth, newHeight)
    }
}
