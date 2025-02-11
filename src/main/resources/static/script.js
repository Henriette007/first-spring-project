const addTaskBtn = document.getElementById('add-task');
const resetBtn = document.getElementById('reset-button');

let taskInput = document.getElementById('todo-list-input');
let todoListItems = document.getElementById('todo-list-items');

function showList(){
    let newInnerHtml = "";
    fetch('/list')
        .then(response => response.json())
        .then(list => {
            list.forEach(task =>{
                newInnerHtml += `
                    <div class="todo-list-single-item" style="width: 350px;" value=${task.id}>
                        <input type="checkbox" id="task-checkbox" class="task-checkbox">
                        <p>${task.task}</p>
                        <button id="delete-button" class="btn delete-btn">Delete</button>
                    </div>`;
                console.log('HTML updated');
            });
            todoListItems.innerHTML = newInnerHtml;
        })
        .catch(error => console.error('Error:', error));
}

function addTask (){
    if (taskInput.value ==='') {
        alert("Please add a task!");
        return;
    }

    fetch("/add", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(taskInput.value)
    })
    .then(response => response.json())
    .then(data => {
        console.log("Item added successfully:", data);
        showList();
    })
    .catch(error => console.error('Error adding item:', error));

    taskInput.value = "";
}

addTaskBtn.addEventListener('click', addTask);

document.addEventListener('click', function(event) {
    if (event.target && event.target.classList.contains('delete-btn')) {
        let array = Array.from(event.target.closest('.todo-list-items').children);
        let taskIndex = array.indexOf(event.target.closest('.todo-list-single-item'));
        let id = array[taskIndex].attributes.getNamedItem('value').value;
        fetch(`/delete/${id}`, {
            method: 'DELETE'
        }).then(response => {
            console.log('Task was deleted.');
            showList();
        });
    }
});

resetBtn.addEventListener('click', function () {
    fetch('/reset', {
        method: 'POST'
    }).then(() => {
        console.log('List was reset.');
        showList();
    });
});

