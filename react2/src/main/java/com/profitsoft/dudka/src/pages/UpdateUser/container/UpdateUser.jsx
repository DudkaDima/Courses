
import React, {useState, useEffect} from 'react'
import Link from "components/Link";
import {useHistory, useParams } from 'react-router-dom';
import UserService from 'pages/UpdateUser/service/UserService'
import { useLocation } from "react-router-dom"
const UpdateUser = () => {

    const [login, setLogin] = useState('')
    const [email, setEmail] = useState('')
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const location = useLocation()  
    const history = useHistory();
    const search = window.location.search;
    const params = new URLSearchParams(search);
    const foo = params.get('id');    
    const id = foo;
   
    
    

    const saveOrUpdateUser = (e) => {
        e.preventDefault();

        const user = {id, login, email, firstName, lastName}

        if(id){
            UserService.updateUser(id, user).then((response) => {
              history.push('/users')
            }).catch(error => {
                console.log(error)
            })

        }else{
            UserService.createUser(user).then((response) =>{

                history.push('/users')
    
            }).catch(error => {
                console.log(error)
            })
        }
        
    }

    useEffect(() => {
        UserService.getUserById(id).then((response) =>{
            setLogin(response.data.login)
            setEmail(response.data.email)
            setFirstName(response.data.firstName)
            setLastName(response.data.lastName)
        }).catch(error => {
            console.log(error)
        })
    }, [])

    const title = () => {

        if(id){
            return <h2 className = "text-center">Update User</h2>
        }else{
            return <h2 className = "text-center">Add User</h2>
        }
    }

    const login1 = () => {
      if(id){
          return <div className = "form-group mb-2">
              <label className = "form-label"> Login :</label>
              <input
                  type = "text"
                  readOnly="true"
                  name = "login"
                  className = "form-control"
                  value = {login}
                  onChange = {(e) => setLogin(e.target.value)}

              >
              </input>
          </div>
      } else {
          return <div className = "form-group mb-2">
              <label className = "form-label"> Login :</label>
              <input
                  type = "text"
                  placeholder = "Enter login "
                  name = "login"
                  className = "form-control"
                  value = {login}
                  onChange = {(e) => setLogin(e.target.value)}
              >
              </input>
          </div>
      }
    }

    return (
        <div>
           <br /><br />
           <div className = "container">
                <div className = "row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                       {
                           title()
                       }
                        <div className = "card-body">
                            <form>

                                {
                                    login1()
                                }
                               

                                <div className = "form-group mb-2">
                                    <label className = "form-label"> Email  :</label>
                                    <input
                                        type = "email"
                                        placeholder = "Enter email "
                                        name = "email"
                                        className = "form-control"
                                        value = {email}
                                        onChange = {(e) => setEmail(e.target.value)}
                                        required
                                    >
                                    </input>
                                </div>

                                <div className = "form-group mb-2">
                                    <label className = "form-label"> First Name :</label>
                                    <input
                                        type = "text"
                                        placeholder = "Enter first name"
                                        name = "firstName"
                                        className = "form-control"
                                        value = {firstName}
                                        onChange = {(e) => setFirstName(e.target.value)}
                                        required
                                    >
                                    </input>
                                </div>

                                <div className = "form-group mb-2">
                                    <label className = "form-label"> Last Name :</label>
                                    <input
                                        type = "text"
                                        placeholder = "Enter last name"
                                        name = "lastName"
                                        className = "form-control"
                                        value = {lastName}
                                        onChange = {(e) => setLastName(e.target.value)}
                                        required
                                    >
                                    </input>
                                </div>
                                <button className = "btn btn-success" onClick = {(e) => saveOrUpdateUser(e)} >Submit </button>
                                <Link to="/users" className="btn btn-danger"> Cancel </Link>
                            </form>

                        </div>
                    </div>
                </div>

           </div>

        </div>
    )
}

export default UpdateUser
