$(document).ready(function() {
	setInterval(repeat, 1);
})

var repeat = function() {
	var m = new Date();
	var m1 = m.getFullYear();
	m1 = m1 + "";

	var m2 = m.getMonth();
	if (m2 < 9)
		m2 = "0" + (m2 + 1);
	else
		m2 = m2 + 1;

	var m3 = m.getDate();
	if (m3 < 10)
		m3 = "0" + m3;
	else
		m3 = "" + m3;

	var m4 = m.getDay();

	var m5 = m.getHours();
	if (m5 < 10)
		m5 = "0" + m5;
	else
		m5 = "" + m5;

	var m6 = m.getMinutes();
	if (m6 < 10)
		m6 = "0" + m6;
	else
		m6 = "" + m6;

	var m7 = m.getSeconds();
	if (m7 < 10)
		m7 = "0" + m7;
	else
		m7 = "" + m7;

	var m8 = m.getMilliseconds()
	if (m8 >= 0 && m8 <= 9)
		m8 = "00" + m8;
	else if (m8 >= 10 && m8 <= 99)
		m8 = "0" + m8;
	else
		m8 = "" + m8;

	var m5_1 = m5.substring(0, 1);
	$(".time_1").html("");
	$("<img/>").appendTo(".time_1").attr("src", "images/time_img/" + m5_1 + ".gif");

	var m5_2 = m5.substring(1, 2);
	$(".time_2").html("");
	$("<img/>").appendTo(".time_2").attr("src", "images/time_img/" + m5_2 + ".gif");

	var m6_1 = m6.substring(0, 1);
	$(".time_3").html("");
	$("<img/>").appendTo(".time_3").attr("src", "images/time_img/" + m6_1 + ".gif");

	var m6_2 = m6.substring(1, 2);
	$(".time_4").html("");
	$("<img/>").appendTo(".time_4").attr("src", "images/time_img/" + m6_2 + ".gif");

	if (m8 <= 500)
		$("#dian").css("background", "url(images/time_img/dian.gif)");
	else
		$("#dian").css("background", "url(images/time_img/dian_bg.gif)");

	var m7_1 = m7.substring(0, 1);
	$(".time_5").html("");
	$("<img/>").appendTo(".time_5").attr("src", "images/time_img/" + m7_1 + ".gif");

	var m7_2 = m7.substring(1, 2);
	$(".time_6").html("");
	$("<img/>").appendTo(".time_6").attr("src", "images/time_img/" + m7_2 + ".gif");

	var m8_1 = m8.substring(0, 1);
	$(".s1").html("");
	$("<img/>").appendTo(".s1").attr("src", "images/time_img/s" + m8_1 + ".gif");

	var m3_1 = m3.substring(0, 1);
	$(".date_left").html("");
	$("<img/>").appendTo(".date_left").attr("src",
			"images/time_img/date_" + m3_1 + ".gif");

	var m3_2 = m3.substring(1, 2);
	$(".date_right").html("");
	$("<img/>").appendTo(".date_right").attr("src",
			"images/time_img/date_" + m3_2 + ".gif");

	var m1_1 = m1.substring(0, 1);
	$(".r_1").html("");
	$("<img/>").appendTo(".r_1").attr("src", "images/time_img/year" + m1_1 + ".gif");

	var m1_2 = m1.substring(1, 2);
	$(".r_2").html("");
	$("<img/>").appendTo(".r_2").attr("src", "images/time_img/year" + m1_2 + ".gif");

	var m1_3 = m1.substring(2, 3);
	$(".r_3").html("");
	$("<img/>").appendTo(".r_3").attr("src", "images/time_img/year" + m1_3 + ".gif");

	var m1_4 = m1.substring(3, 4);
	$(".r_4").html("");
	$("<img/>").appendTo(".r_4").attr("src", "images/time_img/year" + m1_4 + ".gif");

	var m2_1 = m2.substring(0, 1);
	$(".r_5").html("");
	$("<img/>").appendTo(".r_5").attr("src", "images/time_img/year" + m2_1 + ".gif");

	var m2_2 = m2.substring(1, 2);
	$(".r_6").html("");
	$("<img/>").appendTo(".r_6").attr("src", "images/time_img/year" + m2_2 + ".gif");

	m2 = parseInt(m2);
	switch (m2) {
	case 1:
		$(".eng").html("Jan");
		break;
	case 2:
		$(".eng").html("Feb");
		break;
	case 3:
		$(".eng").html("Mar");
		break;
	case 4:
		$(".eng").html("Apr");
		break;
	case 5:
		$(".eng").html("May");
		break;
	case 6:
		$(".eng").html("Jun");
		break;
	case 7:
		$(".eng").html("Jul");
		break;
	case 8:
		$(".eng").html("Aug");
		break;
	case 9:
		$(".eng").html("Sep");
		break;
	case 10:
		$(".eng").html("Oct");
		break;
	case 11:
		$(".eng").html("Nov");
		break;
	case 12:
		$(".eng").html("Dec");
		break;
	}

	switch (m4) {
	case 1:
		$(".zhou span:eq(1)").html("一");
		$(".zhou span:last").html("MON").css("color", "#0d6217");
		break;
	case 2:
		$(".zhou span:eq(1)").html("二");
		$(".zhou span:last").html("TUS").css("color", "#0d6217");
		break;
	case 3:
		$(".zhou span:eq(1)").html("三");
		$(".zhou span:last").html("WEN").css("color", "#0d6217");
		break;
	case 4:
		$(".zhou span:eq(1)").html("四");
		$(".zhou span:last").html("THUR").css("color", "#0d6217");
		break;
	case 5:
		$(".zhou span:eq(1)").html("五");
		$(".zhou span:last").html("FIR").css("color", "#0d6217");
		break;
	case 6:
		$(".zhou span:eq(1)").html("六");
		$(".zhou span:last").html("SAT").css("color", "#0d6217");
		break;
	case 7:
		$(".zhou span:eq(1)").html("日");
		$(".zhou span:last").html("SUN").css("color", "#0d6217");
		break;
	}

}