let page = 0;
let pageInfo;
let titleVar;

function display(page, title) {
    if(!title){
        title = "";
    }
    if(!page){
        page = 0;
    }
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/v1/blogs?page=${page}&title=${title}`,
        success: function (data) {
            pageInfo = data;
            titleVar = title;
            if(data.totalElements === 0){
                $("#blog-list").html(`<tr><td colspan="7">Không có bài viết nào</td></tr>`);
                $("#page-info").text("0 / 0");
                return;
            }

            let content = "";
            
            displayPageNumber();
            console.log(data);
            for (let i = 0; i < data.content.length; i++) {
                content += `<tr>
                    <td>${i + 1}</td>
                    <td>${data.content[i].title}</td>
                    <td class="content-cell">${data.content[i].content}</td>
                    <td>${data.content[i].user.name}</td>
                    <td>${data.content[i].category.name}</td>
                    <td>${data.content[i].date}</td>
                    <td>
                        <button class="btn btn-primary" onclick="viewBlog('${encodeURIComponent(JSON.stringify(data.content[i]))}')">Xem</button>
                        <button class="btn btn-danger" onclick="deleteBlog(${data.content[i].id})">Xóa</button>
                    </td>
                </tr>`
            }
            $("#blog-list").empty().append(content);
        },
        error: function (resp) {
            console.log(resp)
        }
    })
};

function displayNext() {
    if (page < pageInfo.totalPages - 1) {
        page++;
        display(page);
    }
}

function displayPrev() {
    if (page > 0) {
        page--;
        display(page);
    }
}

function updateBlog() {
    let id = $("#id").val();
    let title = $("#title").val();
    let content = $("#content").val();
    let categoryId = $("#category").val();
    let userId = $("#user").val();
    let date = $("#date").val();

    let updateBlog = {
        id: id,
        title: title,
        content: content,
        category: {
            id: categoryId
        },
        user: {
            id: userId
        },
        date: date
    };


    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "http://localhost:8080/api/v1/blogs/" + id,
        data: JSON.stringify(updateBlog),
        success: function () {
            alert("Cập nhật thành công");
            document.getElementById("blog-form").reset();
            display(page, titleVar);
        }, error: function (err) {
            console.log(err)
        }
    })
}

function viewBlog(itemJson) {
    let item = JSON.parse(decodeURIComponent(itemJson));
    $('#id').val(item.id);
    $("#title").val(item.title);
    $("#content").val(item.content);
    $("#category").val(item.category.id);
    $("#user").val(item.user.id);
    $("#date").val(item.date);

    $("#blog-form").slideDown();

    $("#btn-create").hide();
    $("#btn-update").show();
}

function create() {
    let title = $("#title").val();
    let content = $("#content").val();
    let categoryId = $("#category").val();
    let userId = $("#user").val();
    let date = $("#date").val();

    let newBlog = {
        title: title,
        content: content,
        category: {
            id: categoryId
        },
        user: {
            id: userId
        },
        date: date
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newBlog),
        url: "http://localhost:8080/api/v1/blogs",
        success: function () {
            alert("Thành công");
            document.getElementById("blog-form").reset();
            display(page,titleVar);
        }
    })
}

function deleteBlog(id) {
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/api/v1/blogs/${id}`,
        success: function(){
            if(pageInfo.content.length === 1 && page > 0){
                page--;
            }
            display(page, titleVar)
        },
        error: function(resp){
            console.log(resp);
        }
    })
}

function loadCategoryList() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/categories",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option value="${data[i].id}">${data[i].name}</option>`
            }
            $("#category").html(content);
        }
    })
}

function loadUserList() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/users",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option value="${data[i].id}">${data[i].name}</option>`
            }
            $("#user").html(content);
        }
    })
}

function cancel() {
    $("#btn-create").show();
    $("#btn-update").hide();
    $("#blog-form").slideUp();
}

function displayPageNumber(){
    let pageNumber = (page + 1) + " / " + pageInfo.totalPages;
    $("#page-info").html(pageNumber);
}

function searchByTitle(){
    page = 0;
    let inputTitle = $('#search-title').val();
    display(page, inputTitle);
}

$(document).ready(function () {
    // Mọi code bên trong đây sẽ chạy khi DOM đã sẵn sàng

    display(page);
    loadCategoryList();
    loadUserList();

    $("#btn-update").hide();
    $("#btn-next").click(displayNext);
    $("#btn-prev").click(displayPrev);
    $("#btn-search").click(searchByTitle);

    $("#blog-form").hide();
    $(".btn-info").click(function () {
        $("#blog-form").slideToggle();
    });

});