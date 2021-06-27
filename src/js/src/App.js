import { Component } from 'react';
import './App.css';
import {
  get_all_student
} from './client';
import{
  Table,
  Avatar,
  Spin,
  Modal
} from 'antd';
import { LoadingOutlined } from '@ant-design/icons';

import Container from './Container';
import Footer from './footer';

const getSpinIcon = () => <LoadingOutlined style={{ fontSize: 50 }} spin />; 
class App extends Component {


  state = {
    students: [],
    isFetching: false,
    isAddStudentModalVisible: false
  };

  componentDidMount() {
    this.fetchStudents();
  }

  openAddStudentModal = () => this.setState({isAddStudentModalVisible: true});
  closeAddStudentModal = () => this.setState({isAddStudentModalVisible: false});

  fetchStudents = () => {
    this.setState({isFetching: true});
    get_all_student()
      .then(res => res.json())
      .then(students => {
        console.log(students);
        this.setState({
          students,
          isFetching: false
        });
      });
  }


  render() {
    const { students, isFetching } = this.state;

    if (isFetching) {
      return (
        <Container>
          <Spin indicator={getSpinIcon()} />
        </Container>
      )
    }

    if (students && students.length) {
      const columns = [
        {
          title: '',
          key: 'avatar',
          render: (student) => (
            <Avatar size='large'>
              {`${student.firstName.charAt(0).toUpperCase()}${student.lastName.charAt(0).toUpperCase()}`}
            </Avatar>
          )
        },
        {
          title: 'Student ID',
          dataIndex: 'studentId',
          key: 'studentId',
        },
        {
          title: 'First Name',
          dataIndex: 'firstName',
          key: 'firstname',
        },
        {
          title: 'Last Name',
          dataIndex: 'lastName',
          key: 'lastName',
        },
        {
          title: 'Gender',
          dataIndex: 'gender',
          key: 'gender',
        },
        {
          title: 'Email',
          dataIndex: 'student_email',
          key: 'student_email',
        },
        
      ];
      
     return ( 
       <Container>
          <Table dataSource={students} 
          columns={columns} 
          rowKey='studentId' 
          pagination={false}/>
          <Modal 
            title= "visible"
            visible= {this.state.isAddStudentModalVisible}
            onOk= {this.closeAddStudentModal}
            onCancel= {this.closeAddStudentModal}
            width= {1000}
            >
            <h1>hello modal with ant</h1>

          </Modal>
          <Footer numberOfStudents = {students.length}
          handleAddStudentClickEvent={this.openAddStudentModal}/>
       </Container>
     );
    }
    return <h1>no students</h1>
  }
}

export default App;