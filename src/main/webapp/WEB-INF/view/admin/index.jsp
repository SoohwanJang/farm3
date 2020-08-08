<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.farm.web.entity.Member"%>
<%@ page import="com.farm.web.entity.SellerApply"%>
<%@ page import="com.farm.web.controller.admin.IndexController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <main class="admin-main">
            <section class="chart-section">
                <h1 class="d-none">누적데이터</h1>
                <!----- 총 회원 수 / 판매자 수 / 일반 회원 수 ----->
                <section class="member-section">
                    <h1 class="d-none">회원수 변화 그래프</h1>
                    <ul class="chart-menu">
                        <li>
                            <img src="/images/totalmember.png">
                                                        
                            <span>
                                <b>${ct }</b>
                                총 회원
                            </span>
                        </li>
                        <li>
                            <img src="/images/totalmember.png">
                                                        
                            <span>
                                <b>${cs }</b>
                                판매자
                            </span>
                        </li>
                        <li>
                            <img src="/images/totalmember.png">
                                                        
                            <span>
                                <b>${cb }</b>
                                구매자
                            </span>
                        </li>
                    </ul>
                    <div id="chartdiv"></div>
                </section>

                <!----- 누적 방문자 수 / 누적 거래 수 / 거래 진행중 ----->
                <section class="member-section">
                    <h1 class="d-none">방문자 변화 그래프</h1>
                    <ul class="chart-menu">
                        <li>
                            <img src="/images/totalmember.png">
                                                        
                            <span>
                                <b>680</b>
                                누적방문
                            </span>
                        </li>
                        <li>
                            <img src="/images/totalmember.png">
                                                        
                            <span>
                                <b>300</b>
                                누적거래
                            </span>
                        </li>
                        <li>
                            <img src="/images/totalmember.png">
                                                        
                            <span>
                                <b>20</b>
                                진행중
                            </span>
                        </li>
                    </ul>
                    <div id="chartdiv2"></div>
                </section>

                <section class="monthly-section">
                    <h1>월별 등록된 상품 판매량 변화 추이</h1>
                    <div id="chartdiv3"></div>
                </section>
            </section>
            
        </main>
        
        <!------ 차트 스크립트 --------------->
		<!-- 차트 리소스 부분 -->
	    <script src="https://www.amcharts.com/lib/4/core.js"></script>
	    <script src="https://www.amcharts.com/lib/4/charts.js"></script>
	    <script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
	    
        <script>
            am4core.ready(function() {
                
                // Themes begin
                am4core.useTheme(am4themes_animated);
                // Themes end
                
                // Create chart instance
                var chart = am4core.create("chartdiv", am4charts.PieChart);
                
                // Add data
                chart.data = [ {
                "member": "판매자",
                "count": `${cs}`
                }, {
                "member": "구매자",
                "count": `${cb}`
                } ];
                
                // Set inner radius
                chart.innerRadius = am4core.percent(50);
                
                // Add and configure Series
                var pieSeries = chart.series.push(new am4charts.PieSeries());
                pieSeries.dataFields.value = "count";      // 명수
                pieSeries.dataFields.category = "member";  // 맴버
                pieSeries.slices.template.stroke = am4core.color("#fff");
                pieSeries.slices.template.strokeWidth = 2;
                pieSeries.slices.template.strokeOpacity = 1;
                
                // This creates initial animation
                pieSeries.hiddenState.properties.opacity = 1;
                pieSeries.hiddenState.properties.endAngle = -90;
                pieSeries.hiddenState.properties.startAngle = -90;
            }); // end am4core.ready()
    
            am4core.ready(function() {
                
                // Themes begin
                am4core.useTheme(am4themes_animated);
                // Themes end
                
                // Create chart instance
                var chart = am4core.create("chartdiv2", am4charts.XYChart);
                
                // Export
                chart.exporting.menu = new am4core.ExportMenu();
                
                // Data for both series
                var data = [ {
                "연도": "2016",
                "누적 방문자수": 200,
                "누적 거래횟수": 55
                }, {
                "연도": "2017",
                "누적 방문자수": 325,
                "누적 거래횟수": 69
                }, {
                "연도": "2018",
                "누적 방문자수": 346,
                "누적 거래횟수": 79
                }, {
                "연도": "2019",
                "누적 방문자수": 410,
                "누적 거래횟수": 97
                }, {
                // 2020 부분에만 데이터 끼워넣고...나머지는 맞춰서 가데이터로 하면 되네요.
                "연도": "2020",     // 연도
                "누적 방문자수": 530,      // 누적 방문자 수
                "누적 거래횟수": 130,   // 누적 거래거래 수 
                "lineDash": "5,5",
                }, {
                "연도": "2021(목표)",
                "누적 방문자수": 610,
                "누적 거래횟수": 32.9,
                "strokeWidth": 1,
                "columnDash": "5,5",
                "fillOpacity": 0.2,
                "additional": "(projection)"
                } ];
                
                /* Create axes */
                var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
                categoryAxis.dataFields.category = "연도";
                categoryAxis.renderer.minGridDistance = 30;
                
                /* Create value axis */
                var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());


                /* Create series */
                var columnSeries = chart.series.push(new am4charts.ColumnSeries());
                columnSeries.name = "누적 방문자수";
                columnSeries.dataFields.valueY = "누적 방문자수";
                columnSeries.dataFields.categoryX = "연도";
                
                columnSeries.columns.template.tooltipText = "[#fff font-size: 15px]{name} in {categoryX}:\n[/][#fff font-size: 20px]{valueY}[/] [#fff]{additional}[/]"
                columnSeries.columns.template.propertyFields.fillOpacity = "fillOpacity";
                columnSeries.columns.template.propertyFields.stroke = "stroke";
                columnSeries.columns.template.propertyFields.strokeWidth = "strokeWidth";
                columnSeries.columns.template.propertyFields.strokeDasharray = "columnDash";
                columnSeries.tooltip.label.textAlign = "middle";
                
                var lineSeries = chart.series.push(new am4charts.LineSeries());
                lineSeries.name = "누적 거래횟수";
                lineSeries.dataFields.valueY = "누적 거래횟수";
                lineSeries.dataFields.categoryX = "연도";
                
                lineSeries.stroke = am4core.color("#fdd400");
                lineSeries.strokeWidth = 3;
                lineSeries.propertyFields.strokeDasharray = "lineDash";
                lineSeries.tooltip.label.textAlign = "middle";
                
                var bullet = lineSeries.bullets.push(new am4charts.Bullet());
                bullet.fill = am4core.color("#fdd400"); // tooltips grab fill from parent by default
                bullet.tooltipText = "[#fff font-size: 15px]{name} in {categoryX}:\n[/][#fff font-size: 20px]{valueY}[/] [#fff]{additional}[/]"
                var circle = bullet.createChild(am4core.Circle);
                circle.radius = 4;
                circle.fill = am4core.color("#fff");
                circle.strokeWidth = 3;
                
                chart.data = data;
                
            }); // end am4core.ready()

            am4core.ready(function() {
            
            // Themes begin
            am4core.useTheme(am4themes_animated);
            // Themes end
            
            var chart = am4core.create("chartdiv3", am4charts.XYChart);
            
            var data = [];
            var value = 50;
            for(var i = 0; i < 300; i++){
            var date = new Date();
            date.setHours(0,0,0,0);
            date.setDate(i);
            value -= Math.round((Math.random() < 0.5 ? 1 : -1) * Math.random() * 10);
            data.push({date:date, value: value});
            }
            
            chart.data = data;
            
            // Create axes
            var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
            dateAxis.renderer.minGridDistance = 60;
            
            var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
            
            // Create series
            var series = chart.series.push(new am4charts.LineSeries());
            series.dataFields.valueY = "value";
            series.dataFields.dateX = "date";
            series.tooltipText = "{value}"
            
            series.tooltip.pointerOrientation = "vertical";
            
            chart.cursor = new am4charts.XYCursor();
            chart.cursor.snapToSeries = series;
            chart.cursor.xAxis = dateAxis;
            
            //chart.scrollbarY = new am4core.Scrollbar();
            chart.scrollbarX = new am4core.Scrollbar();
            
            }); // end am4core.ready()
        </script>