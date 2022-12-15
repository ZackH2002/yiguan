<%--
  Created by IntelliJ IDEA.
  User: Zack
  Date: 2022/12/15
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
  <script src="../echarts.js"></script>
  <link rel="stylesheet" href="../css/pic_table_in.css" />
</head>
<body>
<!-- <header>
  <hr />
  <h1>易管——仓储管理系统</h1>
  <hr />
</header> -->
<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main" style="height: 500px; width: 1000px"></div>
<script type="text/javascript">
  //   import * as echarts from 'echarts'
  // 基于准备好的dom，初始化echarts实例
  var chartDom = document.getElementById('main')
  var myChart = echarts.init(chartDom)
  var option

  option = {
    title: {
      text: '入库可视化',
      subtext: '每个仓库',
      left: 'center'
    },
    tooltip: {
      trigger: 'item'
    },
    legend: {
      orient: 'vertical',
      left: 'left'
    },
    series: [
      {
        name: 'Access From',
        type: 'pie',
        radius: '50%',
        data: [
          { value: ${sessionScope.listPicIn.get(0).stock}, name: '${sessionScope.listPicIn.get(0).name}' },
          { value: ${sessionScope.listPicIn.get(1).stock}, name: '${sessionScope.listPicIn.get(1).name}' },
          { value: ${sessionScope.listPicIn.get(2).stock}, name: '${sessionScope.listPicIn.get(2).name}' },
          { value: ${sessionScope.listPicIn.get(3).stock}, name: '${sessionScope.listPicIn.get(3).name}' },
          { value: ${sessionScope.listPicIn.get(4).stock}, name: '${sessionScope.listPicIn.get(4).name}' }
        ],
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        }
      }
    ]
  };
  option && myChart.setOption(option)
</script>
</body>
</html>