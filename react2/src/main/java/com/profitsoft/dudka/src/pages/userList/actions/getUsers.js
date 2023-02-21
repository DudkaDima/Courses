const receiveUsers = users => ({
    users , type: 'RECEIVE_USERS'
});
const requestUsers = () => ({ type: 'REQUEST_USERS' });
const errorReceiveUsers = () => ({ type: 'ERROR_RECEIVE_USERS' });

const getUsers = (count) => new Promise((onSuccess) => {

    setTimeout(
        () => onSuccess(Array
            .from(new Array(count).keys())
            .map(index => ({ name: `User ${index}` }))),
        2000
    );
});

const fetchUsers = ({}) => async (dispatch) => {
    dispatch(requestUsers()); 
    return fetch('http://localhost:8080/api/profitsoft/rest/users')
        .then((respone) => respone.json())
        .then((users) => dispatch(receiveUsers(users)))
        .catch(() => dispatch(errorReceiveUsers()));
};
export default {
    fetchUsers,
};
