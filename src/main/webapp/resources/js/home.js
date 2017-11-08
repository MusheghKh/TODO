$(document).ready(function () {

    var baseUrl = "http://localhost:8080";

    var todos = [];

    var part1Index = "<li data-index='";
    var part2Checked = "'><input class='checkbox' type='checkbox' ";
    var part3Title = "/>";
    var part4End = "<a class='remove'>x</a><hr></li>";

    alert(baseUrl + '/api/todos');

    $.get(baseUrl + "/api/todos", {}, function (data) {
        todos = data;

        alert('2');

        $.each(todos, function (index, todo) {
            var part2;
            if(todo.completed === true){
                part2 = "checked='checked'";
            }else {
                part2 = "";
            }
            $('#list-items').append(part1Index + index + part2 + part3Title + todo.title + part4End);
        });
    });

    $('.add-items').submit(function(event)
    {
        event.preventDefault();

        var title = $('#todo-list-item').val();

        if(title && title !== "")
        {
            newTodo = {title: title, completed: false};
            $.post(baseUrl + "/api/todos", newTodo, function (data) {
                todos.append(data);

                var index = todos.length + 1;
                $('#list-items').append(
                    part1Index + index + part2Checked + part3Title + data.title + part4End
                );
                $('#todo-list-item').val("");
            });
        }

    });

    $(document).on('change', '.checkbox', function()
    {
        var index = $(this).parent().attr('data-index');
        var completed = !$(this).attr('checked');
        var todo = todos[index];
        todo.completed = completed;
        $.ajax({
            url: baseUrl + "/api/todos/" + todo.id,
            method: "PUT",
            data: todo,
            success: function (data) {
                todos[index] = data;

                if(completed) {
                    $(this).attr('checked', 'checked');
                } else {
                    $(this).removeAttr('checked');
                }

                $(this).parent().toggleClass('completed');
            }
        });
    });

    $(document).on('click', '.remove', function()
    {
        var index = $(this).parent().attr('data-index');
        $.ajax({
            url: baseUrl + "/api/todos/" + todos[index].id,
            type: "DELETE",
            success: function (data) {
                todos.splice(index, 1);
                $(this).parent().remove();
            }
        });

    });

});