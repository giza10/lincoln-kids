var questionIndex;

/* 画面読み込み完了時の処理 */
$(function() {
    init();
    questionIndex = 1;
});

/* 初期化 */
function init() {
	$("#judge").toggle(false);
	$("#correctImage").hide();
	$("#incorrectImage").hide();
	showQuestion(1);
}

function showQuestion(index) {
	$("#question-title").text("第" + index + "問");
	for (i = 1; i <= 10; i++) {
		if (i == index) {
		    $("#question-" + i).toggle(true);
		} else {
		    $("#question-" + i).toggle(false);
		}
	}
}

function hideQuestions() {
	for (i = 1; i <= 10; i++) {
		$("#question-" + i).toggle(false);
	}
}

/* */
function judge(index, correctAnsIdx) {
	hideQuestions();
	$("#judge").toggle(true);
	if (index == correctAnsIdx) {
		$("#correctImage").show();
		$("#incorrectImage").hide();
	} else {
		$("#correctImage").hide();
		$("#incorrectImage").show();
	}
}

/* */
function goNext() {
	questionIndex ++;
	$("#judge").toggle(false);
	showQuestion(questionIndex);
}

///* ミニカーをブルバック中（タッチされた） */
//function touchstartHandler(event) {
//    event.preventDefault();
//    if(mode != 0) { return; }
//    x0 = event.originalEvent.touches[0].pageX;
//    y0 = event.originalEvent.touches[0].pageY;
//    mode = 1;
//}
///* ミニカーをブルバック中（指を移動した） */
//function touchmoveHandler(event) {
//    event.preventDefault();
//    if(mode != 1) { return; }
//    x1 = event.originalEvent.touches[0].pageX;
//    y1 = event.originalEvent.touches[0].pageY;
//    $("#cartop").css("top", y0 < y1 ? y1 - y0 : 0);
//}
//
///* 元の位置に移動（ミニカーから指が離れた） */
//function touchendHandler(event) {
//    event.preventDefault();
//    if(mode != 1 || event.originalEvent.touches.length > 0) { return; }
//    if (y0 < y1) {
//        length = Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0))
//        pullLength += length;
//        pullLength = pullLength < 2000 ? pullLength : 2000;
//    }
//    $("#cartop").animate({"top": 0}, 250);
//}
//
///* 画面の外に発進！ */
//function go() {
//    mode = 2;
//    $("#cartop").animate({"top": -400 - pullLength}, 1000, run);
//}
//
///* 机の上を走行する */
//function run() {
//    $("#screen1").toggle(false);
//    $("#screen2").toggle(true);
//    $("#retry, #ranking, #register").css("visibility", "hidden");
//    $("#sideview").css("backgroundPosition", "0px 0px");
//    $("#road").css("backgroundPosition", "0px 0px");
//    $("#object").css("left", roadLength + 88);
//    a = pullLength * 0.03;
//    da = a / 30;
//    v = a * 31 / 2;
//    t = 0;
//    runLength = 0;
//    runtimer = setInterval(function() {
//        runLength += v;
//        v -= a;
//        a -= da;
//        t += 100;
//        if(roadLength > runLength) {
//            $("#score").html("あと " + parseInt((roadLength - runLength) / 6) / 10 + "cm");
//        } else {
//            $("#score").html("!! OVER RUN !!");
//        }
//        $("#sideview").css("backgroundPosition", (-runLength * 0.75) + "px 0px");
//        $("#road").css("backgroundPosition", (-runLength) + "px 0px");
//        $("#object").css("left", roadLength - runLength + 88);
//        if(t >= 3000) { stop(); }
//    }, 100);
//}
//
///* 停止 */
//function stop() {
//    if(runtimer != null) {
//        clearInterval(runtimer);
//        runtimer = null;
//    }
//    $("#retry, #register, #ranking").css("visibility", "visible");
//}
//
///* 記録の登録 */
//function register() {
//    if(roadLength - runLength < 0) { return; }
//    var data = { leftLength: roadLength - runLength };
//    $("#updating").toggle(true);
//    $.ajax({
//        cache : false,
//        data : data,
//        dataType : "text",
//        url : "/juststop/register",
//        error : function(XMLHttpRequest, textStatus, errorThrown) {
//        alert('サーバーとの通信に失敗しました');
//        },
//        complete : function(XMLHttpRequest, textStatus) {
//            $("#updating").toggle(false);
//        }
//    });
//}
//
///* ランキングの表示 */
//function ranking() {
//    window.open("/juststop/ranking");
//}
