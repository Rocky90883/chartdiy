        $(function() {
            console.log(1234);
            $("#jsGrid").jsGrid({
                height: "100%",
                width: "100%",
                filtering: false,
                editing: true,
                inserting: true,
                sorting: true,
                paging: true,
                autoload: true,
                pageSize: 15,
                pageButtonCount: 5,
                deleteConfirm: "Do you really want to delete the client?",
                controller: db,
                fields: [
                    // { name: "Name", type: "text", width: 150 },
                    // { name: "Age", type: "number", width: 50 },
                    // { name: "Address", type: "text", width: 200 },
                    // { name: "Country", type: "text", width: 200 },
                    // { name: "Married", type: "text", width: 200 },

                    { zh_name: "门店ID", name: "shopID", type: "text", width: 50,height:20 },
                    { zh_name: "门店名", name: "shopName", type: "text", width: 150 ,height:20},
                    { zh_name: "菜品数", name: "foodCount", type: "text", width: 200 ,height:20},
                    { zh_name: "单据总额", name: "foodAmount", type: "text", width: 200 ,height:20},
                    { zh_name: "日期", name: "reportDate", type: "text", width: 200 ,height:20},

                    // { name: "Country", type: "select", items: db.countries, valueField: "Id", textField: "Name" },
                    // { name: "Married", type: "checkbox", title: "Is Married", sorting: false },
                    { type: "control" }
                ]
            });

        });