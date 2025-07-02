//thêm
function addNewSmartPhone() {
    //Lấy dữ liệu từ form html
    let producer = $('#producer').val();
    let model = $('#model').val();
    let price = $('#price').val();
    let newSmartPhone = {
        producer: producer,
        model: model,
        price: price
    };

    //gọi phương thức ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newSmartPhone),
        //tên API
        url: "http://localhost:8080/api/v1/smartphones",
        //xử lý thành công
        success: function(){
            alert("success!");
            document.getElementById("add-smartphone").reset();
            successHandler();
        }
    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

//hiển thị
function successHandler(){
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/api/v1/smartphones",
        //xử lý khi thành công
        success: function(data){
            //hiển thị danh sách ở đây
             let content = ' <table id="display-list" border="1"><tr>\n' +
                        ' <th>Producer</td>\n' +
                        ' <th>Model</td>\n' +
                        ' <th>Price</td>\n' +
                        ' <th>Delete</td>\n' +
                        ' </tr>';
            for(let i = 0; i < data.length; i++){
                content += getSmartphone(data[i]);
            }
            content += "</table>";
            document.getElementById("smartphoneList").innerHTML = content;
        }
    })
}

//xóa
function deleteSmartphone(id){
    $.ajax({
        type: "DELETE",
        //tên API
        url: `http://localhost:8080/api/v1/smartphones/${id}`,
        //xử lý thành công
        success: successHandler
    })
}

function getSmartphone(smartphone) {
    return `<tr>
                <td>${smartphone.producer}</td>
                <td>${smartphone.model}</td>
                <td>${smartphone.price}</td>
                <td><button onclick="deleteSmartphone(${smartphone.id})">Delete</button></td>
            </tr>`;
}

function init(){
    successHandler();
}

init();