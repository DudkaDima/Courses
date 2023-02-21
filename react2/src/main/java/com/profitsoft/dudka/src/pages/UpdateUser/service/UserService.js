import axios from 'axios'

const EMPLOYEE_BASE_REST_API_URL = 'http://localhost:8080/api/profitsoft/rest';

class UserService{

    getAllUsers(){
        return axios.get(EMPLOYEE_BASE_REST_API_URL)
    }

    createUser(user){
        return axios.post(EMPLOYEE_BASE_REST_API_URL + '/createUser', user)
    }

    getUserById(userId){
        return axios.get(EMPLOYEE_BASE_REST_API_URL + '/userById?id=' + userId);
    }

    updateUser(userId, user){
        return axios.put(EMPLOYEE_BASE_REST_API_URL + '/updateUser/' + userId, user);
    }

    deleteUser(userId){
        return axios.delete(EMPLOYEE_BASE_REST_API_URL + '/delete/' + userId);
    }
}

export default new UserService();