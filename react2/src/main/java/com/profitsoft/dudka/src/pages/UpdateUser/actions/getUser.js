const receiveUser = userId => ({
    userId, type: 'RECEIVE_USER'
});
const requestUser = () => ({ type: 'REQUEST_USER' });
const errorReceiveUser = () => ({ type: 'ERROR_RECEIVE_USER' });

const getUsers = (count) => new Promise((onSuccess) => {

    setTimeout(
        () => onSuccess(Array
            .from(new Array(count).keys())
            .map(index => ({ name: `User! ${index}` }))),
        2000
    );
});

const fetchUser = ({id}) => async (dispatch) => {
    dispatch(requestUser()); 
    return fetch('http://localhost:8080/api/profitsoft/rest/userById?id='+id)
        .then((respone) => respone.json())
        .then((userId) => dispatch(receiveUser(userId)))
        .catch(() => dispatch(errorReceiveUser()));
};


export default {
    fetchUser,
};
