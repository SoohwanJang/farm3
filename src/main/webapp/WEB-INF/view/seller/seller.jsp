<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>은풍한 팜 관리자페이지</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/js/index.js"></script>
    <script src="/js/seller/seller.js"></script>
    
        <!-- 차트 리소스 부분 -->
    <script src="https://www.amcharts.com/lib/4/core.js"></script>
    <script src="https://www.amcharts.com/lib/4/charts.js"></script>
    <script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
    
</head>
<body>
    <header class="admin-header">
        <h1>
            판매자페이지
            <span>판매자님 반갑습니다.</span>
        </h1>
        <ul>
            <li>
                <a href="/index">메인 홈</a>
            </li>
            <li>
                <a href="/seller/index">관리자홈</a>
            </li>
            <li>로그아웃</li>
        </ul>
    </header>
   <div class="admin-body">
        <aside class="aside">
            <h1 class="d-none">관리자페이지 메뉴</h1>
            <ul class="admin-menu">
                <li>
                    <h2 class="admin-menu-title">
                        상품관리
                    </h2>
                    <ul class="admin-draw-menu">
                        <li><a href="/seller/item/reg">상품등록</a></li>
                        <li><a href="/seller/item/list">상품목록</a></li>
                        <li><a href="/seller/item/qna/list">상품문의</a></li>
                        <li><a href="/seller/item/review/list">상품후기</a></li>
                    </ul>
                </li>
                <li>
                    <h2 class="admin-menu-title">매매관리</h2>
                    <ul class="admin-draw-menu">
                        <li><a href="/seller/selling/list">주문현황</a></li>
                    </ul>
                </li>
            </ul>
         </aside>

        <main class="admin-main">
            <section class="chart-section">
                <h1 class="d-none">누적데이터</h1>
                <!----- 총 회원 수 / 판매자 수 / 일반 회원 수 ----->
                <section class="member-section">
                    <h1 class="d-none">회원수 변화 그래프</h1>
                    <ul class="chart-menu">
                        <li>
                            <img src="/images/totalmember.png">                        
                            <span><b>10 (+1)</b>총 상품</span>
                        </li>
                        <li>
                            <img src="/images/totalmember.png">                      
                            <span><b>8 (+1)</b>입금대기</span>
                        </li>
                        <li>
                            <img src="/images/totalmember.png">
                            <span><b>20 (+8)</b>결제완료</span>
                        </li>
                        <li>
                            <img src="/images/totalmember.png">
                            <span><b>40 (+3)</b>배송완료</span>
                        </li>
                        <li>
                            <img src="/images/totalmember.png">
                            <span><b>1 (+1)</b>취소대기</span>
                        </li>
                    </ul>
                    <ul class="chart-menu">
                        <li>
                            <img src="/images/totalmember.png">                        
                            <span><b>10 (+1)</b>총 상품</span>
                        </li>
                     </ul>   
                   
                    <div id="chartdiv2"></div>
                </section>

                
            </section>

        </main>
    </div>
    <footer class="footer">
        
        <button class="up-button"> </button>
    </footer>
<!--------------- 차트 스크립트 --------------->

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
                "count": 110
                }, {
                "member": "구매자",
                "count": 90
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
                "월": "Apr",
                "누적 판매량": 200,
                "누적 매출": 100
                }, {
               	"월": "May",
                "누적 판매량": 325,
                "누적 매출": 150
                }, {
               	"월": "Jun",
                "누적 판매량": 346,
                "누적 매출": 170
                }, {
               	"월": "Jul",
                "누적 판매량": 410,
                "누적 매출": 176
                }, {
               	"월": "Aug",
                "누적 판매량": 410,
                "누적 매출": 181
                 },{
                // 2020 부분에만 데이터 끼워넣고...나머지는 맞춰서 가데이터로 하면 되네요.
                "월": "Sep(목표)",     // 연도
                "누적 판매량": 530,      // 누적 방문자 수
                "누적 매출": 187,   // 누적 거래거래 수 
                "lineDash": "5,5"
                }, {
                "연도": "Aug (목표)",
                "누적 판매량": 610,
                "누적 매출": 200,
                "strokeWidth": 1,
                "columnDash": "5,5",
                "fillOpacity": 0.2,
                "additional": "(projection)"
                } ];
                
                /* Create axes */
                var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
                categoryAxis.dataFields.category = "월";
                categoryAxis.renderer.minGridDistance = 30;
                
                /* Create value axis */
                var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());


                /* Create series */
                var columnSeries = chart.series.push(new am4charts.ColumnSeries());
                columnSeries.name = "누적 판매량";
                columnSeries.dataFields.valueY = "누적 판매량";
                columnSeries.dataFields.categoryX = "월";
                
                columnSeries.columns.template.tooltipText = "[#fff font-size: 15px]{name} in {categoryX}:\n[/][#fff font-size: 20px]{valueY}[/] [#fff]{additional}[/]"
                columnSeries.columns.template.propertyFields.fillOpacity = "fillOpacity";
                columnSeries.columns.template.propertyFields.stroke = "stroke";
                columnSeries.columns.template.propertyFields.strokeWidth = "strokeWidth";
                columnSeries.columns.template.propertyFields.strokeDasharray = "columnDash";
                columnSeries.tooltip.label.textAlign = "middle";
                
                var lineSeries = chart.series.push(new am4charts.LineSeries());
                lineSeries.name = "누적 매출";
                lineSeries.dataFields.valueY = "누적 매출";
                lineSeries.dataFields.categoryX = "월";
                
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
    
</body>
</html>