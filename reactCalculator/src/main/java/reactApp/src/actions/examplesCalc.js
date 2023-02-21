const receiveExamples = examples => ({
    examples, type: 'RECEIVE_EXAMPLES'
});

const requestExamples = () => ({ type: 'REQUEST_EXAMPLES' });

const errorReceiveExamples = () => ({ type: 'ERROR_RECEIVE_EXAMPLES' });

const getExamples = (count) => new Promise((onSuccess) => {

    setTimeout(

        () => onSuccess(Array

            .from(new Array(count).keys())

            .map(index => ({ name: `Example ${index}` }))),

        2000

    );

});

const fetchExamples = ({ mathCount }) => async (dispatch) => {

    dispatch(requestExamples()); // Повідомляю стору, що роблю запит користувачівоми
    
    return fetch('http://localhost:8080/math/examples?count=' + mathCount)
        .then((respone) => respone.json())
        .then((mathExamples) => dispatch(receiveExamples(mathExamples)))
        .catch(() => dispatch(errorReceiveExamples()));

};

export default {
    fetchExamples,
};