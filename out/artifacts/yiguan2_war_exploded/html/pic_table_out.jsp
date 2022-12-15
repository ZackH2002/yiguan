<%--
  Created by IntelliJ IDEA.
  User: Zack
  Date: 2022/12/15
  Time: 20:38
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
    tooltip: {
      trigger: 'item'
    },
    legend: {
      top: '5%',
      left: 'center'
    },
    series: [
      {
        name: 'Access From',
        type: 'pie',
        radius: ['40%', '70%'],
        avoidLabelOverlap: false,
        itemStyle: {
          borderRadius: 10,
          borderColor: '#fff',
          borderWidth: 2
        },
        label: {
          show: false,
          position: 'center'
        },
        emphasis: {
          label: {
            show: true,
            fontSize: 40,
            fontWeight: 'bold'
          }
        },
        labelLine: {
          show: false
        },
        data: [
          { value: 1048, name: 'Search Engine' },
          { value: 735, name: 'Direct' },
          { value: 580, name: 'Email' },
          { value: 484, name: 'Union Ads' },
          { value: 300, name: 'Video Ads' }
        ]
      }
    ]
  };

  option && myChart.setOption(option)
</script>
</body>
</html>
