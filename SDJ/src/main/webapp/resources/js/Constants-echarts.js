var Constants_Echarts = {
    PIE_OPTION: {
        title: {
            text: '75',
            x: 'center',
            y: 'center',
            textStyle: {
                fontWeight: 'normal',
            }
        },
        tooltip: {
            show: false

        },
        legend: {
            show: false
        },
        series: [
            {
                name: '',
                type: 'pie',
                radius: ['85%', '100%'],
                avoidLabelOverlap: false,
                hoverAnimation: false,

                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data: [
                    {value: 335, name: ''},
                    {value: 1548, name: ''}
                ]
            }
        ],
        color: ['red', 'rgb(180,180,180)']
    },
    BAR_OPTION: {
        title: {
            show: false
        },
        backgroundColor: '#f8f8f8',
        animation: true,
        tooltip: {
            show: false
        },

        legend: {
            show: false

        },

        xAxis: {
            type: 'value',
            position: 'bottom',
            splitLine: {
                lineStyle: {
                    type: 'dashed',
                    color: '#cfc3bd'
                }
            },
            axisLabel: {show: true}
        },
        yAxis: {
            type: 'category',
            axisLine: {
                lineStyle: {
                    type: 'solid',
                }
            },

            axisLabel: {
                interval: 0,
                show: true,
                rotate: 0,
                textStyle: {
                    color: 'black'
                }
            },
            axisTick: {
                show: true
            },
            splitLine: {
                lineStyle: {
                    type: 'solid',
                    color: '#cfc3bd'
                }
            },
            data: []
        },
        grid: {
            x: 80,
            x2: 30,
            y: 20,
            y2: 0
        },
        series: [{
            barWidth: 15,
            name: '',
            type: 'bar',
            barGap: '-100%',
            clickable: true,
            label: {
                normal: {
                    textStyle: {
                        color: 'black',
                    },
                    position: 'right',
                    show: true,
                },
            },
            itemStyle: {
                normal: {
                    color: 'rgb(64,179,233)'

                }
            },
            data: []
        }]
    },
    LINE_OPTION: {

        title: {
            show: false
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['最高气温', '最低气温'],
            right: '20',
            top: '0',
            orient: 'horizontal'

        },
        grid: {right: '30', top: '30', bottom: '20'},
        toolbox: {
            show: false
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: [0],
            splitLine: {
                show: true,
                lineStyle: {
                    width: 2,
                    type: 'dotted'  //'dotted'虚线 'solid'实线
                }
            }
        },
        yAxis: {
            type: 'value',
            axisLabel: {
                formatter: '{value} °C'
            }
        },
        series: [
            {
                name: '最高气温',
                type: 'line',
                data: [0]
            },
            {
                name: '最低气温',
                type: 'line',
                data: [0]
            }
        ]
    }


};