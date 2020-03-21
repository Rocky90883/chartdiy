// // var msg = [[${mb}]];                //这里取得后端传过来的json
// // objdto = JSON.parse(msg);       //这里将取得json转成js对象
//
// function  gethualalaData() {
//     console.log('请求');
//     $.ajax({
//         type: "get",
//         contentType:'application/json',
//         dataType: "text",
//         url: "http://localhost:8080/hualala/queryByIdOrderStatus?pageNum=2&size=10&orderStatus=30&shopName=广州番禺光明南路直营店",
//         async: false,
//         data: {},
//         success: function (data) {
//             console.log(data)
//             console.log("1111")
//             var objdto
//             objdto = JSON.parse(data)
//             console.log(objdto);
//         },
//         err: function (data) {
//             console.log('err');
//         }
//     });
// }
